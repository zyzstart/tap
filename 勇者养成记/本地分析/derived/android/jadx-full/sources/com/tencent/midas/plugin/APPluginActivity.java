package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginActivity extends android.app.Activity implements com.tencent.midas.plugin.IAPPluginActivity {
    public android.app.Activity mProxyActivity = null;
    public android.app.Activity mActivity = null;
    public android.content.Context mContext = null;
    protected android.view.View mProxyContentView = null;
    protected java.lang.String mPluginName = "";
    protected java.lang.String mApkFilePath = "";
    protected android.content.pm.PackageInfo mPackageInfo = null;
    protected boolean mIsRunInPlugin = false;
    private java.lang.ClassLoader mDexClassLoader = null;
    private boolean mFinished = false;

    public static final android.graphics.Bitmap getDrawableBitmap(android.graphics.drawable.Drawable drawable) {
        if (drawable != null && (drawable instanceof android.graphics.drawable.BitmapDrawable)) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IDispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return dispatchTouchEvent(motionEvent);
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IFinish() {
        finish();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public android.view.View IGetContentView() {
        return this.mProxyContentView;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public android.os.Handler IGetInHandler() {
        return null;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public android.content.res.Resources IGetResource() {
        android.content.Context context = this.mContext;
        return context != null ? context.getResources() : this.mActivity.getResources();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IInit(java.lang.String str, java.lang.String str2, android.app.Activity activity, java.lang.ClassLoader classLoader, android.content.pm.PackageInfo packageInfo) {
        this.mIsRunInPlugin = true;
        this.mDexClassLoader = classLoader;
        this.mProxyActivity = activity;
        this.mPluginName = str;
        this.mApkFilePath = str2;
        this.mPackageInfo = packageInfo;
        com.tencent.midas.plugin.APPluginContext aPPluginContext = new com.tencent.midas.plugin.APPluginContext(activity, 0, str2, classLoader);
        this.mContext = aPPluginContext;
        attachBaseContext(aPPluginContext);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IIsWrapContent() {
        return true;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnActivityResult(int i, int i2, android.content.Intent intent) {
        onActivityResult(i, i2, intent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnConfigurationChanged(android.content.res.Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnCreate(android.os.Bundle bundle) {
        onCreate(bundle);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnCreateOptionsMenu(android.view.Menu menu) {
        return onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnDestroy() {
        onDestroy();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyDown(int i, android.view.KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        return onKeyMultiple(i, i2, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyUp(int i, android.view.KeyEvent keyEvent) {
        return onKeyUp(i, keyEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnMenuItemSelected(int i, android.view.MenuItem menuItem) {
        return onMenuItemSelected(i, menuItem);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnNewIntent(android.content.Intent intent) {
        onNewIntent(intent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnOptionsItemSelected(android.view.MenuItem menuItem) {
        return onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnPause() {
        onPause();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnPrepareOptionsMenu(android.view.Menu menu) {
        return onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @android.annotation.TargetApi(23)
    public void IOnRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestart() {
        onRestart();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestoreInstanceState(android.os.Bundle bundle) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnResume() {
        onResume();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnSaveInstanceState(android.os.Bundle bundle) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStart() {
        onStart();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStop() {
        onStop();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnTouchEvent(android.view.MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnUserInteraction() {
        onUserInteraction();
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnWindowFocusChanged(boolean z) {
        onWindowFocusChanged(z);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @android.annotation.TargetApi(23)
    public void IRequestPermissions(java.lang.String[] strArr, int i) {
        requestPermissions(strArr, i);
        com.tencent.midas.comm.APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + strArr + ", requestCode=" + i);
        if (this.mIsRunInPlugin) {
            return;
        }
        super.requestPermissions(strArr, i);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetIntent(android.content.Intent intent) {
        setIntent(intent);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetOutHandler(android.os.Handler handler) {
    }

    @Override // android.app.Activity
    public android.view.View findViewById(int i) {
        android.view.View view;
        if (!this.mIsRunInPlugin || (view = this.mProxyContentView) == null) {
            return super.findViewById(i);
        }
        android.view.View viewFindViewById = view.findViewById(i);
        return viewFindViewById == null ? super.findViewById(i) : viewFindViewById;
    }

    @Override // android.app.Activity
    public void finish() {
        com.tencent.midas.comm.APLog.i("APPluginActivity", "APPluginActivity finish");
        if (!this.mIsRunInPlugin) {
            super.finish();
            return;
        }
        int iIntValue = 0;
        android.content.Intent intent = null;
        synchronized (this) {
            try {
                java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mResultCode");
                declaredField.setAccessible(true);
                iIntValue = ((java.lang.Integer) declaredField.get(this)).intValue();
                java.lang.reflect.Field declaredField2 = android.app.Activity.class.getDeclaredField("mResultData");
                declaredField2.setAccessible(true);
                intent = (android.content.Intent) declaredField2.get(this);
            } catch (java.lang.Exception e) {
                android.util.Log.e("Midas", "APPluginActivity finish Exception:" + e.toString());
            }
        }
        this.mProxyActivity.setResult(iIntValue, intent);
        this.mProxyActivity.finish();
        this.mFinished = true;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context getApplicationContext() {
        com.tencent.midas.comm.APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
        return this.mIsRunInPlugin ? this.mProxyActivity.getApplicationContext() : super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.pm.ApplicationInfo getApplicationInfo() {
        return this.mIsRunInPlugin ? this.mPackageInfo.applicationInfo : super.getApplicationInfo();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mIsRunInPlugin ? this.mProxyActivity.getChangingConfigurations() : super.getChangingConfigurations();
    }

    public android.content.res.Resources getHostResources() {
        return this.mProxyActivity.getResources();
    }

    @Override // android.app.Activity
    public android.view.LayoutInflater getLayoutInflater() {
        android.content.Context context = this.mContext;
        return context != null ? android.view.LayoutInflater.from(context) : android.view.LayoutInflater.from(this.mActivity);
    }

    public android.app.Activity getOutActivity() {
        return this.mProxyActivity;
    }

    public android.content.res.Resources getOutResources() {
        return (this.mIsRunInPlugin ? this.mProxyActivity : this.mActivity).getResources();
    }

    public android.content.pm.PackageInfo getPackageInfo() {
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getPackageName() {
        return this.mIsRunInPlugin ? this.mPackageInfo.packageName : super.getPackageName();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        if ("window".equals(str) || "search".equals(str)) {
            return this.mIsRunInPlugin ? this.mProxyActivity.getSystemService(str) : super.getSystemService(str);
        }
        android.content.Context context = this.mContext;
        return context != null ? context.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public android.view.Window getWindow() {
        return this.mIsRunInPlugin ? this.mProxyActivity.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public android.view.WindowManager getWindowManager() {
        return this.mIsRunInPlugin ? this.mProxyActivity.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mIsRunInPlugin ? this.mFinished : super.isFinishing();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.midas.comm.APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        if (this.mIsRunInPlugin) {
            this.mActivity = this.mProxyActivity;
            com.tencent.midas.plugin.APPluginStatic.add(this);
        } else {
            super.onCreate(bundle);
            this.mActivity = this;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.tencent.midas.comm.APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
        if (!this.mIsRunInPlugin) {
            super.onDestroy();
        } else {
            this.mDexClassLoader = null;
            com.tencent.midas.plugin.APPluginStatic.remove(this);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onPause();
    }

    @Override // android.app.Activity
    @android.annotation.TargetApi(23)
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.tencent.midas.comm.APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=" + i);
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mIsRunInPlugin) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.mIsRunInPlugin) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        if (this.mIsRunInPlugin) {
            this.mProxyActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.mIsRunInPlugin) {
            this.mActivity.overridePendingTransition(i, i2);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        if (!this.mIsRunInPlugin) {
            super.setContentView(i);
            return;
        }
        android.view.View viewInflate = android.view.LayoutInflater.from(this).inflate(i, (android.view.ViewGroup) null);
        this.mProxyContentView = viewInflate;
        this.mActivity.setContentView(viewInflate);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        if (!this.mIsRunInPlugin) {
            super.setContentView(view);
        } else {
            this.mProxyContentView = view;
            this.mActivity.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mIsRunInPlugin) {
            this.mProxyActivity.setTheme(i);
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        boolean booleanExtra;
        if (!this.mIsRunInPlugin) {
            super.startActivityForResult(intent, i);
            return;
        }
        if (intent.hasExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY)) {
            booleanExtra = intent.getBooleanExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY, false);
        } else {
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = this.mActivity.getPackageManager().queryIntentActivities(intent, 65536);
            booleanExtra = listQueryIntentActivities == null || listQueryIntentActivities.size() == 0;
        }
        if (booleanExtra) {
            intent.putExtra("pluginsdk_IsPluginActivity", true);
        }
        this.mActivity.startActivityForResult(intent, i);
    }
}
