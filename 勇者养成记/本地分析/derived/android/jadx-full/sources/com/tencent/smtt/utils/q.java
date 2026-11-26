package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.io.File f986a;

    public static long a() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    @android.annotation.TargetApi(9)
    public static boolean a(android.content.Context context) {
        java.io.File tbsFolderDir;
        if (context == null) {
            return false;
        }
        if (f986a != null) {
            return true;
        }
        try {
            if (context.getApplicationInfo().processName.contains("com.tencent.mm") && (tbsFolderDir = com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context)) != null && tbsFolderDir.isDirectory()) {
                java.io.File file = new java.io.File(tbsFolderDir, com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_SHARE);
                if (!file.isDirectory() && !file.mkdir()) {
                    return false;
                }
                f986a = file;
                file.setExecutable(true, false);
                return true;
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
