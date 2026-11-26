package com.jakewharton.processphoenix;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ProcessPhoenix extends android.app.Activity {
    private static final java.lang.String KEY_MAIN_PROCESS_PID = "phoenix_main_process_pid";
    private static final java.lang.String KEY_RESTART_INTENTS = "phoenix_restart_intents";

    private static android.content.Intent getRestartIntent(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            return launchIntentForPackage;
        }
        throw new java.lang.IllegalStateException("Unable to determine default activity for " + packageName + ". Does an activity specify the DEFAULT category in its intent filter?");
    }

    public static boolean isPhoenixProcess(android.content.Context context) {
        int iMyPid = android.os.Process.myPid();
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName.endsWith(":phoenix")) {
                return true;
            }
        }
        return false;
    }

    public static void triggerRebirth(android.content.Context context) {
        triggerRebirth(context, getRestartIntent(context));
    }

    public static void triggerRebirth(android.content.Context context, android.content.Intent... intentArr) {
        if (intentArr.length < 1) {
            throw new java.lang.IllegalArgumentException("intents cannot be empty");
        }
        intentArr[0].addFlags(268468224);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.jakewharton.processphoenix.ProcessPhoenix.class);
        intent.addFlags(268435456);
        intent.putParcelableArrayListExtra(KEY_RESTART_INTENTS, new java.util.ArrayList<>(java.util.Arrays.asList(intentArr)));
        intent.putExtra(KEY_MAIN_PROCESS_PID, android.os.Process.myPid());
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.os.Process.killProcess(getIntent().getIntExtra(KEY_MAIN_PROCESS_PID, -1));
        java.util.ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(KEY_RESTART_INTENTS);
        startActivities((android.content.Intent[]) parcelableArrayListExtra.toArray(new android.content.Intent[parcelableArrayListExtra.size()]));
        finish();
        java.lang.Runtime.getRuntime().exit(0);
    }
}
