package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m {
    public static boolean a(android.content.Context context) {
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            return b(context);
        }
        return true;
    }

    private static boolean a(java.io.File file) {
        try {
            return !com.tencent.smtt.utils.e.b(file);
        } catch (java.lang.Throwable th) {
            android.util.Log.e("TbsCheckUtils", "isOatFileBroken exception: " + th);
            return false;
        }
    }

    public static boolean b(android.content.Context context) {
        java.io.File fileC;
        try {
            if (android.os.Build.VERSION.SDK_INT < 21 || android.os.Build.VERSION.SDK_INT > 25 || (fileC = c(context)) == null) {
                return true;
            }
            for (java.io.File file : fileC.listFiles(new java.io.FileFilter() { // from class: com.tencent.smtt.utils.m.1
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file2) {
                    java.lang.String name = file2.getName();
                    return !android.text.TextUtils.isEmpty(name) && name.endsWith(".dex");
                }
            })) {
                if (file.isFile() && file.exists()) {
                    if (a(file)) {
                        com.tencent.smtt.utils.TbsLog.w("TbsCheckUtils", "" + file + " is invalid --> check failed!");
                        file.delete();
                        return false;
                    }
                    com.tencent.smtt.utils.TbsLog.i("TbsCheckUtils", "" + file + " #4 check success!");
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.tencent.smtt.utils.TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
        return true;
    }

    private static java.io.File c(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "core_share");
        if (file.isDirectory() && file.exists()) {
            return file;
        }
        return null;
    }
}
