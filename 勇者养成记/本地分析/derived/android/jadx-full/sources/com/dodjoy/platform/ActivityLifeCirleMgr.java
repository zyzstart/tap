package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActivityLifeCirleMgr {
    private static com.dodjoy.platform.ActivityLifeCirleMgr _instance;
    private java.util.List<com.dodjoy.platform.IActivityLifeCircle> mLifeCircleList = new java.util.ArrayList();

    private ActivityLifeCirleMgr() {
    }

    public static com.dodjoy.platform.ActivityLifeCirleMgr getInstance() {
        if (_instance == null) {
            _instance = new com.dodjoy.platform.ActivityLifeCirleMgr();
        }
        return _instance;
    }

    public void AddLifeCircle(com.dodjoy.platform.IActivityLifeCircle iActivityLifeCircle) {
        if (iActivityLifeCircle != null) {
            this.mLifeCircleList.add(iActivityLifeCircle);
        }
    }

    public void attachBaseContext(android.content.Context context) {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).attachBaseContext(context);
        }
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        for (int i3 = 0; i3 < this.mLifeCircleList.size(); i3++) {
            this.mLifeCircleList.get(i3).onActivityResult(i, i2, intent);
        }
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onDestroy();
        }
    }

    public void onNewIntent(android.content.Intent intent) {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onNewIntent(intent);
        }
    }

    public void onPause() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onPause();
        }
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        for (int i2 = 0; i2 < this.mLifeCircleList.size(); i2++) {
            this.mLifeCircleList.get(i2).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onRestart() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onRestart();
        }
    }

    public void onResume() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onResume();
        }
    }

    public void onSaveInstanceState(android.os.Bundle bundle) {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onStart();
        }
    }

    public void onStop() {
        for (int i = 0; i < this.mLifeCircleList.size(); i++) {
            this.mLifeCircleList.get(i).onStop();
        }
    }
}
