package com.dodjoy.utilities;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodBaseContext {
    private static android.content.Context mApplicationContext;
    private static android.app.Activity mGameActivity;
    private static com.dodjoy.utilities.IUnityPlayer mUnityPlayer;

    public static android.content.Context GetApplicationContext() {
        return mApplicationContext;
    }

    public static java.lang.String GetDataDir() {
        java.io.File externalFilesDir;
        android.app.Activity activity = mGameActivity;
        if (activity == null || (externalFilesDir = activity.getExternalFilesDir(null)) == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static android.app.Activity GetGameActivity() {
        return mGameActivity;
    }

    public static void SetUnityPlayer(com.dodjoy.utilities.IUnityPlayer iUnityPlayer) {
        mUnityPlayer = iUnityPlayer;
        if (iUnityPlayer != null) {
            mGameActivity = iUnityPlayer.GetGameActivity();
            mApplicationContext = mGameActivity.getApplicationContext();
        } else {
            mGameActivity = null;
            mApplicationContext = null;
        }
    }

    public static void UnitySendMessage(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.dodjoy.utilities.IUnityPlayer iUnityPlayer = mUnityPlayer;
        if (iUnityPlayer != null) {
            iUnityPlayer.UnitySendMessage(str, str2, str3);
        }
    }
}
