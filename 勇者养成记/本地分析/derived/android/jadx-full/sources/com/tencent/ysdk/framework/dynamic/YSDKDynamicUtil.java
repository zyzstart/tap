package com.tencent.ysdk.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKDynamicUtil {
    private static final java.lang.String CORE_API = "com.tencent.ysdk.core.framework.YSDKInnerApi";
    private static final java.lang.String INIT_METHOD = "init";
    private static final java.lang.String REPORT_ERROR_METHOD = "reportStatError";
    private static final java.lang.String SHELL_API = "com.tencent.ysdk.shell.framework.YSDKInnerApi";
    private static final java.lang.String TAG = "YSDKDynamicUtil";

    private static java.util.Set getLibDirABI() {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            for (java.lang.String str : android.os.Build.SUPPORTED_ABIS) {
                linkedHashSet.addAll(mapABI(str));
            }
        } else {
            linkedHashSet.addAll(mapABI(android.os.Build.CPU_ABI));
        }
        return linkedHashSet;
    }

    public static java.lang.Object invoke(java.lang.String str, java.lang.Object... objArr) {
        try {
            return com.tencent.ysdk.framework.YSDKInitProvider.isLoadPlugin() ? com.tencent.ysdk.framework.dynamic.invoke.PluginCall.on(CORE_API).call(str, objArr).get() : com.tencent.ysdk.framework.dynamic.utils.Reflect.on(SHELL_API).call(str, objArr).get();
        } catch (java.lang.Throwable th) {
            byte b = -1;
            int iHashCode = str.hashCode();
            if (iHashCode != -938011328) {
                if (iHashCode == 3237136 && str.equals("init")) {
                    b = 0;
                }
            } else if (str.equals(REPORT_ERROR_METHOD)) {
                b = 1;
            }
            if (b == 0) {
                com.tencent.ysdk.framework.YSDKInitProvider.clearLoadedPlugin(com.tencent.ysdk.framework.YSDKInitProvider.getApplicationContext());
            } else if (b != 1) {
                com.tencent.ysdk.framework.YSDKInitProvider.dealWithLaunchCrash();
                com.tencent.ysdk.innerapi.DynamicInnerApi.reportStatError(null, th);
            } else {
                com.tencent.ysdk.framework.YSDKInitProvider.dealWithLaunchCrash();
            }
            return null;
        }
    }

    private static void loadDefaultSo(java.lang.String str) {
        com.tencent.ysdk.libware.file.Logger.d(TAG, "loadDefaultSo");
        try {
            java.lang.System.loadLibrary(str);
            com.tencent.ysdk.libware.file.Logger.d(TAG, "YSDKSo module is OK");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.ysdk.libware.file.Logger.d(TAG, "YSDKSo module is bad");
        }
    }

    private static boolean loadPatchLib(java.io.File file, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (file == null || android.text.TextUtils.isEmpty(str)) {
            str2 = TAG;
            str3 = "illegal parameter!";
        } else {
            if (!str.endsWith(".so")) {
                java.io.File file2 = null;
                java.lang.String str4 = "lib" + str + ".so";
                for (java.lang.String str5 : getLibDirABI()) {
                    java.io.File file3 = new java.io.File(file.getAbsolutePath() + "/" + str4);
                    if (file3.exists() && file3.length() > 0) {
                        file2 = file3;
                        break;
                    }
                }
                if (file2 != null) {
                    com.tencent.ysdk.libware.file.Logger.d(TAG, "find matched lib file : " + file2.getAbsolutePath());
                    try {
                        java.lang.System.load(file2.getAbsolutePath());
                        com.tencent.ysdk.libware.file.Logger.d(TAG, "load patch lib success : " + str);
                        return true;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
            str2 = TAG;
            str3 = "illegal libName!";
        }
        com.tencent.ysdk.libware.file.Logger.d(str2, str3);
        return false;
    }

    private static boolean loadPatchLib(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = TAG;
            str3 = "illegal parameter!";
        } else {
            if (!str.endsWith(".so")) {
                return loadPatchLib(new java.io.File(com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginInfo().getPluginFileInfo().getLibPath()), str);
            }
            str2 = TAG;
            str3 = "illegal libName!";
        }
        com.tencent.ysdk.libware.file.Logger.d(str2, str3);
        return false;
    }

    public static void loadSo(java.lang.String str) {
        loadDefaultSo(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    private static java.util.Set mapABI(java.lang.String str) {
        java.lang.String str2;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        switch (str) {
            case "armeabi-v7a":
            case "armeabi-v7a-hard":
                linkedHashSet.add("armeabi-v7a");
                break;
            case "armeabi":
                break;
            case "arm64-v8a":
                str2 = "arm64-v8a";
                linkedHashSet.add(str2);
                return linkedHashSet;
            case "x86":
                str2 = com.bun.miitmdid.core.Utils.CPU_ABI_X86;
                linkedHashSet.add(str2);
                return linkedHashSet;
            case "x86_64":
                str2 = "x86_64";
                linkedHashSet.add(str2);
                return linkedHashSet;
            case "mips":
                str2 = "mips";
                linkedHashSet.add(str2);
                return linkedHashSet;
            case "mips64":
                str2 = "mips64";
                linkedHashSet.add(str2);
                return linkedHashSet;
            default:
                return linkedHashSet;
        }
        str2 = "armeabi";
        linkedHashSet.add(str2);
        return linkedHashSet;
    }
}
