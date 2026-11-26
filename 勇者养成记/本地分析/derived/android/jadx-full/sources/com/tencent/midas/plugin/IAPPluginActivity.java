package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAPPluginActivity {
    boolean IDispatchTouchEvent(android.view.MotionEvent motionEvent);

    void IFinish();

    android.view.View IGetContentView();

    android.os.Handler IGetInHandler();

    android.content.res.Resources IGetResource();

    void IInit(java.lang.String str, java.lang.String str2, android.app.Activity activity, java.lang.ClassLoader classLoader, android.content.pm.PackageInfo packageInfo);

    boolean IIsWrapContent();

    void IOnActivityResult(int i, int i2, android.content.Intent intent);

    void IOnConfigurationChanged(android.content.res.Configuration configuration);

    void IOnCreate(android.os.Bundle bundle);

    boolean IOnCreateOptionsMenu(android.view.Menu menu);

    void IOnDestroy();

    boolean IOnKeyDown(int i, android.view.KeyEvent keyEvent);

    boolean IOnKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent);

    boolean IOnKeyUp(int i, android.view.KeyEvent keyEvent);

    boolean IOnMenuItemSelected(int i, android.view.MenuItem menuItem);

    void IOnNewIntent(android.content.Intent intent);

    boolean IOnOptionsItemSelected(android.view.MenuItem menuItem);

    void IOnPause();

    boolean IOnPrepareOptionsMenu(android.view.Menu menu);

    @android.annotation.TargetApi(23)
    void IOnRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr);

    void IOnRestart();

    void IOnRestoreInstanceState(android.os.Bundle bundle);

    void IOnResume();

    void IOnSaveInstanceState(android.os.Bundle bundle);

    void IOnStart();

    void IOnStop();

    boolean IOnTouchEvent(android.view.MotionEvent motionEvent);

    void IOnUserInteraction();

    void IOnWindowFocusChanged(boolean z);

    @android.annotation.TargetApi(23)
    void IRequestPermissions(java.lang.String[] strArr, int i);

    void ISetIntent(android.content.Intent intent);

    void ISetOutHandler(android.os.Handler handler);
}
