package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IActivityLifeCircle {
    void attachBaseContext(android.content.Context context);

    void onActivityResult(int i, int i2, android.content.Intent intent);

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
}
