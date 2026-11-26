package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IThirdPlatform {
    void DealMessage(int i, java.lang.String str);

    void GameToPlatformLogout();

    void attachBaseContext(android.content.Context context);

    void doSdkPay(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, float f, java.lang.String str4);

    int exitGame();

    java.lang.String getChannelName();

    java.lang.String getSdkCountryInfo();

    void initThirdSdk();

    void initWithInstance(android.app.Activity activity, android.os.Bundle bundle);

    int login();

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void onBackPressed();

    void onConfigurationChanged(android.content.res.Configuration configuration);

    void onDestroy();

    void onNewIntent(android.content.Intent intent);

    void onPause();

    void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr);

    void onRestart();

    void onResume();

    void onSaveInstanceState(android.os.Bundle bundle);

    void onStart();

    void onStop();

    void preventIndulge();

    boolean quickLogin();

    void reqSpringGameFBAct(int i, boolean z);

    boolean supportSwitchAccount();
}
