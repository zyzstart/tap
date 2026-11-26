package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static java.lang.String a(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            int iMyPid = android.os.Process.myPid();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return "";
            }
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                    com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Current process info: pid = %d, name = %s ", java.lang.Integer.valueOf(iMyPid), runningAppProcessInfo.processName), new java.lang.Object[0]);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Exception while get current process name", th);
            return "";
        }
    }
}
