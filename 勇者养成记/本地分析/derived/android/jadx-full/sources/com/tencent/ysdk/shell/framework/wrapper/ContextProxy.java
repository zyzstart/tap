package com.tencent.ysdk.shell.framework.wrapper;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ContextProxy {
    private ContextProxy() {
    }

    public static android.content.pm.ActivityInfo getActivityInfo(android.content.Context context, java.lang.String str, java.lang.String str2) throws android.content.pm.PackageManager.NameNotFoundException {
        return context == null ? new android.content.pm.ActivityInfo() : context.getPackageManager().getActivityInfo(new android.content.ComponentName(str, str2), 128);
    }

    public static java.io.InputStream getInputStreamFromAssets(android.content.Context context, java.lang.String str) throws java.io.IOException {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getResources().getAssets().open(str);
    }

    public static android.content.pm.PackageManager getPackageManager(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getPackageManager();
    }

    public static java.lang.String getPackageName(android.content.Context context) {
        return context == null ? "" : context.getApplicationContext().getPackageName();
    }
}
