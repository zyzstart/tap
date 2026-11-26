package com.tencent.ysdk.libware.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FileUtil {
    public static final java.lang.String APP_SDCARD_AMOUNT_ROOT_PATH = "/tencent/YSDK";
    public static final java.lang.String APP_SDCARD_UNAMOUNT_ROOT_PATH = "/YSDK";
    private static final java.lang.String TAG = "FileUtils";

    public static java.lang.String getCommonRootDir(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            java.lang.String commonRootDirOnAndroidQ = getCommonRootDirOnAndroidQ(context);
            if (!android.text.TextUtils.isEmpty(commonRootDirOnAndroidQ)) {
                return commonRootDirOnAndroidQ;
            }
            java.lang.String commonRootDirBelowAndroidQ = getCommonRootDirBelowAndroidQ(context);
            return android.text.TextUtils.isEmpty(commonRootDirBelowAndroidQ) ? "" : commonRootDirBelowAndroidQ;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, e);
            com.tencent.ysdk.innerapi.DynamicInnerApi.reportStatError(null, e);
            return "";
        }
    }

    private static java.lang.String getCommonRootDirBelowAndroidQ(android.content.Context context) {
        if (!com.tencent.ysdk.innerapi.DynamicInnerApi.isExternalStorageAvailable(context)) {
            return context.getFilesDir().getAbsolutePath() + "/YSDK";
        }
        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + "/tencent/YSDK");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static java.lang.String getCommonRootDirOnAndroidQ(android.content.Context context) {
        java.io.File externalFilesDir;
        if (android.os.Build.VERSION.SDK_INT < 29 || (externalFilesDir = context.getExternalFilesDir("/tencent/YSDK")) == null) {
            return "";
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir.getAbsolutePath();
    }
}
