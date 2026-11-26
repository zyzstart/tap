package com.dodjoy.unityplayer;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodUnityPlayerActivity extends android.app.Activity implements com.dodjoy.utilities.IUnityPlayer {
    protected com.dodjoy.dodlib.DodLib mDodLib = new com.dodjoy.dodlib.DodLib();
    protected com.unity3d.player.UnityPlayer mUnityPlayer;

    @android.annotation.TargetApi(19)
    private void HideNaviBar() {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.mUnityPlayer.setSystemUiVisibility(5894);
        }
    }

    public com.dodjoy.dodlib.DodLib GetDodLib() {
        return this.mDodLib;
    }

    @Override // com.dodjoy.utilities.IUnityPlayer
    public android.app.Activity GetGameActivity() {
        return this;
    }

    @Override // com.dodjoy.utilities.IUnityPlayer
    public void UnitySendMessage(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.mUnityPlayer != null) {
            com.unity3d.player.UnityPlayer.UnitySendMessage(str, str2, str3);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
        com.dodjoy.platform.PlatformInterface.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return keyEvent.getAction() == 2 ? this.mUnityPlayer.injectEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.dodjoy.platform.PlatformInterface.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.dodjoy.platform.PlatformInterface.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
        com.dodjoy.platform.PlatformInterface.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.dodjoy.platform.PlatformInterface.init(this, "", bundle);
        this.mDodLib.Create(this, com.dodjoy.utilities.DodBaseContext.GetDataDir());
        this.mUnityPlayer = new com.unity3d.player.UnityPlayer(this);
        setContentView(this.mUnityPlayer);
        this.mUnityPlayer.requestFocus();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        android.util.Log.e("Unity", "activity on destroy " + com.dodjoy.dodlib.DodLib.isFinish);
        com.dodjoy.platform.PlatformInterface.onDestroy();
        this.mDodLib.Destroy();
        super.onDestroy();
        this.mUnityPlayer.destroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.mUnityPlayer.injectEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        setIntent(intent);
        com.dodjoy.platform.PlatformInterface.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        android.util.Log.e("Unity", "on pause is finish " + com.dodjoy.dodlib.DodLib.isFinish);
        if (!com.dodjoy.dodlib.DodLib.isFinish) {
            this.mUnityPlayer.pause();
        }
        com.dodjoy.platform.PlatformInterface.onPause();
    }

    @Override // android.app.Activity
    @android.annotation.TargetApi(23)
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        this.mDodLib.onRequestPermissionsResult(i, strArr, iArr);
        com.dodjoy.platform.PlatformInterface.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.dodjoy.platform.PlatformInterface.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mUnityPlayer.resume();
        com.dodjoy.platform.PlatformInterface.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            java.lang.reflect.Method declaredMethod = this.mUnityPlayer.getClass().getDeclaredMethod(com.unisound.common.y.D, new java.lang.Class[0]);
            if (declaredMethod != null) {
                declaredMethod.invoke(this.mUnityPlayer, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        com.dodjoy.platform.PlatformInterface.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        try {
            java.lang.reflect.Method declaredMethod = this.mUnityPlayer.getClass().getDeclaredMethod(com.unisound.common.y.F, new java.lang.Class[0]);
            if (declaredMethod != null) {
                declaredMethod.invoke(this.mUnityPlayer, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        com.dodjoy.platform.PlatformInterface.onStop();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mUnityPlayer.injectEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            this.mUnityPlayer.lowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
        if (z) {
            HideNaviBar();
        }
    }

    protected java.lang.String updateUnityCommandLineArguments(java.lang.String str) {
        return str;
    }
}
