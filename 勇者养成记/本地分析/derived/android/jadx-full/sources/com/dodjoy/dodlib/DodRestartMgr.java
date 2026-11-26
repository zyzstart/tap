package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodRestartMgr extends com.dodjoy.dodlib.DodLibBaseMgr {
    private android.content.Context mApplicationContext;
    private android.app.PendingIntent mRestartPending = null;
    private int m_delayTimeMs;

    private void SetTimer(android.app.PendingIntent pendingIntent, int i) {
        ((android.app.AlarmManager) this.mApplicationContext.getSystemService(android.support.v4.app.NotificationCompat.CATEGORY_ALARM)).set(1, java.lang.System.currentTimeMillis() + ((long) i), pendingIntent);
        android.util.Log.e("Unity", "Game exist, restart after 1 sec.....");
        java.lang.String str = com.dodjoy.utils.DodLog.TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Game exist, restart after ");
        double d = i;
        java.lang.Double.isNaN(d);
        sb.append(d / 1000.0d);
        sb.append(" sec.....");
        com.dodjoy.utils.DodLog.e(str, sb.toString());
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        this.mApplicationContext = activity.getApplicationContext();
        return true;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public void Destroy() {
    }

    public void RestartApp(int i) {
        android.content.Context context = this.mApplicationContext;
        if (context == null) {
            com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "restart failed, mContext is null");
            return;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.lang.String packageName = this.mApplicationContext.getPackageName();
        android.content.Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "Restart app ....");
            SetTimer(android.app.PendingIntent.getActivity(this.mApplicationContext, 0, launchIntentForPackage, 268435456), i);
            com.dodjoy.dodlib.DodLib.isFinish = true;
        } else {
            android.util.Log.e("Unity", "Dodlib restart failed, getLaunchIntentForPackage " + packageName + " failed");
        }
    }
}
