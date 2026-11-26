package com.tencent.tmapkupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkUpdateManager {
    protected static final java.lang.String TAG = "TMSelfUpdate_ApkUpdateManager";
    private static com.tencent.tmapkupdatesdk.ApkUpdateManager instance;
    private com.tencent.yybsdk.apkpatch.r mApkPatchListener = null;

    public static synchronized com.tencent.tmapkupdatesdk.ApkUpdateManager getInstance() {
        if (instance == null) {
            instance = new com.tencent.tmapkupdatesdk.ApkUpdateManager();
        }
        return instance;
    }

    public void addCheckUpdateListener(com.tencent.tmapkupdatesdk.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (aVar == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener == null");
        } else {
            com.tencent.tmapkupdatesdk.internal.logic.a.a().a(aVar);
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public void checkUpdate(java.util.List list) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (list == null || list.size() <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "packageNameList == null || packageNameList.size() <= 0");
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "packageNameList.size: " + list.size());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                java.lang.String str = (java.lang.String) it.next();
                arrayList.add(new com.tencent.tmapkupdatesdk.ApkUpdateParam(str, 0, 0));
                sb.append(str);
                sb.append(";");
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "packageNameList: " + sb.toString());
            checkUpdateList(arrayList);
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public void checkUpdateList(java.util.List list) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (list == null || list.size() <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "updateParamList == null || updateParamList.size() <= 0");
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "updateParamList size: " + list.size());
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "send Message ApkUpdateMessageHandler.GetApkInfo ");
            android.os.Message messageObtainMessage = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
            messageObtainMessage.what = 5;
            messageObtainMessage.obj = list;
            messageObtainMessage.sendToTarget();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public void destory() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().c();
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public void init(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "appContext is null");
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "appContext:" + context);
            com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().a(context);
            com.tencent.tmapkupdatesdk.internal.c.a.a().a(context);
            com.tencent.tmassistantbase.util.k.a().a(context);
            com.tencent.yybsdk.apkpatch.s.a().b(context);
            com.tencent.yybsdk.apkpatch.s.a().b(com.tencent.tmassistantbase.util.k.a().f());
            com.tencent.yybsdk.apkpatch.s.a().a(com.tencent.tmassistantbase.util.k.a().d);
            com.tencent.yybsdk.apkpatch.s.a().a(true, com.tencent.tmassistantbase.util.TMLog.isWriteLogToFile);
            com.tencent.tmdownloader.internal.a.a.b().c();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public int patchNewApk(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "packageName:" + str + "; patchPath:" + str2 + "; newGenApkPath:" + str3);
        int iB = com.tencent.tmapkupdatesdk.internal.a.e.b(str, str2, str3);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("patchNewApk resultCode:");
        sb.append(iB);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return iB;
    }

    public int patchNewApkByPath(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "oldPath:" + str + "; patchPath:" + str2 + "; newGenApkPath:" + str3);
        android.content.pm.PackageManager packageManager = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b().getPackageManager();
        int iA = new com.tencent.tmapkupdatesdk.internal.a.e().a(str, str2, str3);
        if (iA == 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "genNewApk succeed");
            if (packageManager.getPackageArchiveInfo(str3, 1) == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                return -11;
            }
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "genNewApk failed errcode: " + iA);
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "patchNewApkByPath resultCode: " + iA);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return iA;
    }

    public int patchNewApkByTMAPath(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        long length;
        com.tencent.yybsdk.apkpatch.b.a aVar = new com.tencent.yybsdk.apkpatch.b.a(str2);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "<patchNewApkByTMAPath> start build new apk: ApkPatchManager.getInstance().startTask(patchTask)");
        com.tencent.yybsdk.apkpatch.s.a().a(new com.tencent.yybsdk.apkpatch.u(apkUpdateDetail.url, str, aVar, str3, apkUpdateDetail.patchAlgorithm, null));
        java.io.File file = new java.io.File(str2);
        if (file.exists()) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "patchFile.length = " + file.length());
            length = file.length();
        } else {
            length = 0;
        }
        aVar.a(length, length);
        return 0;
    }

    public int patchNewApkTMA(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        try {
            android.content.pm.PackageInfo packageInfo = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return patchNewApkByTMAPath(packageInfo.applicationInfo.sourceDir, str2, str3, apkUpdateDetail);
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return -1;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: ", e);
            return -1;
        }
    }

    public void removeListener(com.tencent.tmapkupdatesdk.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (aVar == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener == null");
        } else {
            com.tencent.tmapkupdatesdk.internal.logic.a.a().b(aVar);
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public void setApkPatchListener(com.tencent.yybsdk.apkpatch.r rVar) {
        this.mApkPatchListener = rVar;
        if (rVar != null) {
            com.tencent.yybsdk.apkpatch.s.a().a(this.mApkPatchListener);
        }
    }
}
