package com.tencent.smtt.export.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LibraryLoader {
    private static java.lang.String[] sLibrarySearchPaths;

    public static java.lang.String[] getLibrarySearchPaths(android.content.Context context) {
        java.lang.String[] strArr = sLibrarySearchPaths;
        if (strArr != null) {
            return strArr;
        }
        if (context == null) {
            return new java.lang.String[]{"/system/lib"};
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(getNativeLibraryDir(context));
        arrayList.add("/system/lib");
        java.lang.String[] strArr2 = new java.lang.String[arrayList.size()];
        arrayList.toArray(strArr2);
        sLibrarySearchPaths = strArr2;
        return strArr2;
    }

    public static java.lang.String getNativeLibraryDir(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 9) {
            return context.getApplicationInfo().nativeLibraryDir;
        }
        if (i >= 4) {
            return context.getApplicationInfo().dataDir + "/lib";
        }
        return "/data/data/" + context.getPackageName() + "/lib";
    }

    public static void loadLibrary(android.content.Context context, java.lang.String str) {
        java.lang.String[] librarySearchPaths = getLibrarySearchPaths(context);
        java.lang.String strMapLibraryName = java.lang.System.mapLibraryName(str);
        for (java.lang.String str2 : librarySearchPaths) {
            java.lang.String str3 = str2 + "/" + strMapLibraryName;
            if (new java.io.File(str3).exists()) {
                try {
                    java.lang.System.load(str3);
                    return;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            java.lang.System.loadLibrary(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
