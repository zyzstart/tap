package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginChecker {
    private static final java.lang.String TAG = "APPluginChecker";

    private static boolean isAllPluginValid(java.io.File file) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        if (file == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot check all plugin valid, pluginPath is null!");
            return false;
        }
        com.tencent.midas.comm.APLog.d(TAG, "Check all plugin valid, parameter ok!");
        try {
            java.io.File file2 = new java.io.File(file.getCanonicalPath() + java.io.File.separator + com.tencent.midas.plugin.APPluginConfig.SIGN_FILE_NAME);
            if (!file2.exists()) {
                com.tencent.midas.comm.APLog.e(TAG, "Check all plugin valid, sign file is not found");
                return false;
            }
            com.tencent.midas.comm.APLog.d(TAG, "Check all plugin valid, sign file exist!");
            java.util.HashMap map = new java.util.HashMap();
            com.tencent.midas.plugin.APPluginUtils.readSingInfo(map, file2);
            int i = 0;
            for (java.io.File file3 : file.listFiles()) {
                java.lang.String name = file3.getName();
                com.tencent.midas.comm.APLog.d(TAG, "Check all plugin valid, current check file = " + name);
                if (name.startsWith("MidasSign") || !name.startsWith("Midas")) {
                    str = TAG;
                    sb = new java.lang.StringBuilder();
                    sb.append("Check all plugin valid, ignore = ");
                    sb.append(name);
                } else {
                    java.lang.String str2 = (java.lang.String) map.get(name.split("\\_")[0]);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        if (com.tencent.midas.plugin.APPluginUtils.checkFileMD5(file3.getCanonicalPath(), str2)) {
                            i++;
                            str = TAG;
                            sb = new java.lang.StringBuilder();
                            sb.append("Check all plugin valid, current check file = ");
                            sb.append(name);
                            sb.append(", MD5 OK");
                        } else {
                            com.tencent.midas.comm.APLog.d(TAG, "Check all plugin valid, current check file = " + name + ", MD5 not OK");
                            file3.delete();
                        }
                    }
                }
                com.tencent.midas.comm.APLog.d(str, sb.toString());
            }
            if (i != map.size() || i < 2) {
                com.tencent.midas.comm.APLog.e(TAG, "Check all plugin valid, all valid file num = " + i + ", but sign file size = " + map.size() + ", check fail!");
                return false;
            }
            com.tencent.midas.comm.APLog.d(TAG, "Check all plugin valid, all valid file num = " + i + ", sign file size = " + map.size() + ", check success!");
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isPluginValid(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "Calling into isPluginValid " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        return isAllPluginValid(com.tencent.midas.plugin.APPluginConfig.getPluginPath(context));
    }
}
