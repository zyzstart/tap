package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APApkFileParser {
    public static android.graphics.drawable.Drawable getAPKIcon(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null && packageArchiveInfo.applicationInfo != null) {
                android.content.pm.ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                java.lang.Class<?> cls = java.lang.Class.forName("android.content.res.AssetManager");
                android.content.res.AssetManager assetManager = (android.content.res.AssetManager) cls.getConstructor(null).newInstance(null);
                cls.getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assetManager, str);
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                displayMetrics.setToDefaults();
                android.content.res.Resources resources = new android.content.res.Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
                if (applicationInfo.icon != 0) {
                    return resources.getDrawable(applicationInfo.icon);
                }
                return null;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static android.content.pm.PackageInfo getPackageInfo(android.content.Context context, java.lang.String str, int i) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, i);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean isApkFileBroken(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        return packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null;
    }

    public static boolean isSignaturesSame(android.content.pm.Signature[] signatureArr, android.content.pm.Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null) {
            return true;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (android.content.pm.Signature signature : signatureArr) {
            hashSet.add(signature);
        }
        java.util.HashSet hashSet2 = new java.util.HashSet();
        for (android.content.pm.Signature signature2 : signatureArr2) {
            hashSet2.add(signature2);
        }
        return hashSet.equals(hashSet2);
    }
}
