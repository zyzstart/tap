package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static com.tencent.tmselfupdatesdk.a c = null;
    private static boolean j = true;
    private android.content.Context d;
    private com.tencent.tmapkupdatesdk.model.ApkUpdateDetail i;
    private long p;
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f1145a = "";
    protected byte b = 0;
    private com.tencent.tmapkupdatesdk.a m = new com.tencent.tmselfupdatesdk.b(this);
    private com.tencent.yybsdk.apkpatch.r n = new com.tencent.tmselfupdatesdk.d(this);
    private com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener o = new com.tencent.tmselfupdatesdk.e(this);
    private java.lang.ref.ReferenceQueue k = new java.lang.ref.ReferenceQueue();
    private java.util.ArrayList l = new java.util.ArrayList();
    private android.os.Handler e = new android.os.Handler(com.tencent.tmassistantbase.util.l.a().getLooper());

    private a() {
    }

    public static synchronized com.tencent.tmselfupdatesdk.a a() {
        if (c == null) {
            c = new com.tencent.tmselfupdatesdk.a();
        }
        return c;
    }

    private void a(int i, int i2) {
        int i3;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<reportUpdateState>,state = " + i + ",errorCode = " + i2);
        int i4 = 6;
        if (i == 100) {
            i2 = 0;
            i4 = 4;
            i3 = com.tencent.pipe.IPipeInterface.EVENT_PAY_IS_LOGIN;
        } else if (i != 102) {
            switch (i) {
                case 4:
                    if (!h()) {
                        i4 = 4;
                        i3 = 303;
                    } else {
                        i4 = 4;
                        i3 = 302;
                    }
                    break;
                case 5:
                case 6:
                    i3 = !h() ? com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR : 402;
                    break;
                default:
                    i4 = -1;
                    i3 = -1;
                    break;
            }
        } else {
            i3 = 401;
        }
        if (-1 != i4) {
            com.tencent.tmselfupdatesdk.p.a(i4, i3, i2);
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<reportUpdateState>,state = " + i + " is not report state,return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Bundle bundle, com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState;
        if (d() == null) {
            a(102, -18, "SelfUpdate failure, TMAssistantDownloadSDKClient_IS_NULL!");
            return;
        }
        bundle.putByte(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, (byte) 3);
        bundle.putLong(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.FILE_SIZE, apkUpdateDetail.patchsize);
        int iStartDownloadTask = d().startDownloadTask(this.i.url, 2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF, null, null, bundle);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "apkPatch start download Result :" + iStartDownloadTask);
        if (4 != iStartDownloadTask || (downloadTaskState = d().getDownloadTaskState(this.i.url)) == null) {
            return;
        }
        java.lang.String str = downloadTaskState.mSavePath;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "apkPatch has yet exists：url:" + this.i.url + ";  patchPath:" + str);
        short s = apkUpdateDetail.patchAlgorithm;
        if (s == 32 || s == 64) {
            a(apkUpdateDetail, str);
        } else {
            d(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        this.e.post(new com.tencent.tmselfupdatesdk.c(this, apkUpdateDetail));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    private void a(com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<patchGenInstallNew> enter ");
        if (apkUpdateDetail == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String str2 = str + "_" + this.g + "_new.apk";
        this.f = str2;
        java.io.File file = new java.io.File(str2);
        if (file.exists()) {
            if (this.d.getPackageManager().getPackageArchiveInfo(str2, 1) != null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "new apk has yet exists：url:" + this.i.url + ";  newPath:" + str2);
                c(str2);
                a(100, -14, "SelfUpdate success,New Pakage is exists!");
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
                return;
            }
            file.delete();
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<patchGenInstallNew> new apk dont exit or illegal, begin patch new apk ");
        this.p = java.lang.System.currentTimeMillis();
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().patchNewApkTMA(this.g, str, str2, apkUpdateDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo tMSelfUpdateUpdateInfo) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        if (tMSelfUpdateUpdateInfo == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "upateinfo == null");
        } else {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "upateinfo: (status = " + tMSelfUpdateUpdateInfo.getStatus() + "; updateMedthod = " + tMSelfUpdateUpdateInfo.getUpdateMethod() + "; newApkSize = " + tMSelfUpdateUpdateInfo.getNewApkSize() + "; patchSize = " + tMSelfUpdateUpdateInfo.getPatchSize() + "; newFeature = " + tMSelfUpdateUpdateInfo.getNewFeature() + "; updateDownloadUrl = " + tMSelfUpdateUpdateInfo.getUpdateDownloadUrl() + ")");
            java.util.ArrayList arrayList = this.l;
            if (arrayList != null && arrayList.size() > 0) {
                java.util.Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
                    if (obj == null) {
                        com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_CommonUpdateManager", "onCheckNeedUpdateInfo listener = null");
                    } else if (obj instanceof com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) {
                        ((com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) obj).onUpdateInfoReceived(tMSelfUpdateUpdateInfo);
                    }
                }
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.os.Bundle bundle, com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        java.lang.String str;
        if (d() == null) {
            a(102, -18, "SelfUpdate failure, TMAssistantDownloadSDKClient_IS_NULL!");
            return;
        }
        bundle.putByte(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, (byte) 1);
        bundle.putLong(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.FILE_SIZE, apkUpdateDetail.newapksize);
        int iStartDownloadTask = d().startDownloadTask(this.i.url, 2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK, null, null, bundle);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "newapk start download Result :" + iStartDownloadTask);
        if (4 == iStartDownloadTask) {
            com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState = d().getDownloadTaskState(this.i.url);
            if (downloadTaskState != null) {
                java.lang.String str2 = downloadTaskState.mSavePath;
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "newapk has yet exists：url:" + this.i.url + "; apkPath:" + str2);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "downloadUpdateApk overwriteChannelid = " + ((int) this.i.overwriteChannelid));
                    a(str2);
                    c(str2);
                    a(100, 0, "SelfUpdate success !");
                    return;
                }
                str = "SelfUpdate failure, SelfUpdateSDKErrorCode_getSavePath_IS_NULL!";
            } else {
                str = "SelfUpdate failure, SelfUpdateSDKErrorCode_GetDownloadTaskState_IS_NULL!";
            }
            a(102, -19, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        int i;
        java.lang.String str2;
        com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail = this.i;
        int i2 = apkUpdateDetail.updatemethod;
        if (i2 == 4) {
            d(str);
            return;
        }
        if (i2 == 5 && apkUpdateDetail != null) {
            a(apkUpdateDetail, str);
            return;
        }
        int i3 = this.i.updatemethod;
        if (i3 == 2) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "OnDownloadSDKTaskStateChanged download finished overwriteChannelid = " + ((int) this.i.overwriteChannelid));
            a(str);
            c(str);
            i = 0;
            str2 = "SelfUpdate success !";
        } else if (i3 != 1) {
            a(102, -20, "OnDownloadSDKTaskStateChanged,OnDownloadSDKTaskStateChanged,unknown exception!");
            return;
        } else {
            i = -15;
            str2 = "SelfUpdate success, NO Update!";
        }
        a(100, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !this.g.equals(com.tencent.tmassistantbase.util.a.b(this.d, str))) {
            return;
        }
        com.tencent.tmselfupdatesdk.p.a(9, java.lang.String.valueOf(109), this.g);
        com.tencent.tmassistantbase.util.a.a(this.d, str);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:15:0x0119  */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x00dd, please report this as an issue */
    private void d(java.lang.String str) {
        int iPatchNewApk;
        long jCurrentTimeMillis;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<patchGenInstallOld> enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "patchPath: " + str);
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String str2 = str + "_" + this.g + "_new.apk";
            java.io.File file = new java.io.File(str2);
            if (!file.exists()) {
                a(103, 0, "SelfUpdate generating new apk!");
                long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                iPatchNewApk = com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().patchNewApk(this.g, str, str2);
                jCurrentTimeMillis = java.lang.System.currentTimeMillis() - jCurrentTimeMillis2;
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "now begin gen New apk; result=" + iPatchNewApk + "; packageName=" + this.g + "; patchPath=" + str + "; newGenApkPath=" + str2);
                if (iPatchNewApk == 0) {
                    com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_old_algorithm_result", true, java.lang.String.valueOf(jCurrentTimeMillis), this.g);
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "patchGenInstall overwriteChannelid = " + ((int) this.i.overwriteChannelid));
                    a(str2);
                    c(str2);
                    a(100, 0, "SelfUpdate success !");
                } else {
                    com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_old_algorithm_result", false, java.lang.String.valueOf(iPatchNewApk), this.g);
                    a(102, iPatchNewApk, "SelfUpdate failure,genNewApk failure!");
                }
            } else if (this.d.getPackageManager().getPackageArchiveInfo(str2, 1) != null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "new apk has yet exists：url:" + this.i.url + ";  newPath:" + str2);
                c(str2);
                a(100, -14, "SelfUpdate success,New Pakage is exists!");
            } else {
                file.delete();
                a(103, 0, "SelfUpdate generating new apk!");
                long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
                iPatchNewApk = com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().patchNewApk(this.g, str, str2);
                jCurrentTimeMillis = java.lang.System.currentTimeMillis() - jCurrentTimeMillis3;
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "now begin gen New apk; result=" + iPatchNewApk + "; packageName=" + this.g + "; patchPath=" + str + "; newGenApkPath=" + str2);
                if (iPatchNewApk == 0) {
                    com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_old_algorithm_result", true, java.lang.String.valueOf(jCurrentTimeMillis), this.g);
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "patchGenInstall overwriteChannelid = " + ((int) this.i.overwriteChannelid));
                    a(str2);
                    c(str2);
                    a(100, 0, "SelfUpdate success !");
                } else {
                    com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_old_algorithm_result", false, java.lang.String.valueOf(iPatchNewApk), this.g);
                    a(102, iPatchNewApk, "SelfUpdate failure,genNewApk failure!");
                }
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo g() {
        int i;
        int i2 = this.i.updatemethod;
        if (i2 == 1) {
            i = 0;
        } else if (i2 == 2) {
            i = 1;
        } else if (i2 == 4 || i2 == 5) {
            i = 2;
        } else {
            i = 0;
        }
        com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail = this.i;
        return new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo(0, i, apkUpdateDetail.newapksize, apkUpdateDetail.patchsize, apkUpdateDetail.newFeature, apkUpdateDetail.url, apkUpdateDetail.overwriteChannelid, apkUpdateDetail.versionname, apkUpdateDetail.versioncode);
    }

    private boolean h() {
        try {
            return com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled() == 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void a(int i, int i2, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "onAppStateChanged state: " + i + "; errorCode: " + i2 + "; errorMsg: " + str);
        java.util.Iterator it = this.l.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "listener == null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) {
                ((com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) obj).onDownloadAppStateChanged(i, i2, str);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "test0629 state = " + i + ", 100:success, 102:failture");
        a(i, i2);
    }

    public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.d = context;
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().initTMAssistantCallYYBApi(this.d);
        this.g = this.d.getPackageName();
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().init(this.d);
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().setApkPatchListener(this.n);
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().addCheckUpdateListener(this.m);
        this.h = str;
        this.f1145a = str2;
    }

    protected void a(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter overwriteChannelid = " + ((int) this.i.overwriteChannelid));
        if (this.i.overwriteChannelid == 1) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "writeChannelIdPath: " + str);
            try {
                android.content.pm.PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.g, 0);
                if (packageInfo != null) {
                    java.lang.String str2 = packageInfo.applicationInfo.sourceDir;
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "writeOldCommentToNewFile; result=" + com.tencent.tmselfupdatesdk.a.a.a.a(str2, str) + "; packageName=" + this.g + "; oldApk=" + str2 + "; newGenApkPath=" + str);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_CommonUpdateManager", "exception: ", e);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    public boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        while (true) {
            java.lang.ref.Reference referencePoll = this.k.poll();
            if (referencePoll == null) {
                break;
            }
            this.l.remove(referencePoll);
        }
        java.util.Iterator it = this.l.iterator();
        while (it.hasNext()) {
            if (((java.lang.ref.WeakReference) it.next()).get() == obj) {
                return true;
            }
        }
        this.l.add(new java.lang.ref.WeakReference(obj, this.k));
        return true;
    }

    public void b() {
        com.tencent.tmselfupdatesdk.p.a(23, java.lang.String.valueOf(104));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "hostPackageName: " + this.g);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.g);
        j = false;
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().checkUpdate(arrayList);
        com.tencent.tmassistantbase.c.a.a.a().a("checkSelfUpdate");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    public void c() {
        com.tencent.tmselfupdatesdk.p.a(3, 201, 0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.g);
        j = true;
        this.b = (byte) 1;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "checkUpdate: hostPackageName = " + this.g);
        com.tencent.tmapkupdatesdk.ApkUpdateManager.getInstance().checkUpdate(arrayList);
    }

    com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient d() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient downloadSDKClient = com.tencent.tmdownloader.TMAssistantDownloadManager.getInstance(this.d).getDownloadSDKClient("selfUpdateSDK_client_sdkupdate");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "get selfUpdateSDK_client_sdkupdate");
        if (downloadSDKClient != null) {
            downloadSDKClient.registerDownloadTaskListener(this.o);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "returnValue(client): " + downloadSDKClient);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
        return downloadSDKClient;
    }

    public void e() {
        java.util.ArrayList arrayList = this.l;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
