package com.tencent.tmapkupdatesdk.internal.logic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.os.HandlerThread f997a;
    private static com.tencent.tmapkupdatesdk.internal.logic.a b;
    private final java.util.ArrayList c;
    private java.util.concurrent.ConcurrentHashMap d;
    private final java.util.HashMap e;

    private a(android.os.Looper looper) {
        super(looper);
        this.c = new java.util.ArrayList();
        this.d = new java.util.concurrent.ConcurrentHashMap();
        this.e = new java.util.HashMap();
    }

    public static synchronized com.tencent.tmapkupdatesdk.internal.logic.a a() {
        if (b == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("apkupdate_asyctask");
            f997a = handlerThread;
            handlerThread.setPriority(10);
            f997a.start();
            b = new com.tencent.tmapkupdatesdk.internal.logic.a(f997a.getLooper());
        }
        return b;
    }

    private synchronized int b(java.util.List list) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        if (list != null) {
            if (list.size() > 0) {
                android.content.pm.PackageManager packageManager = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b().getPackageManager();
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo) it.next();
                    if (!this.e.containsKey(appUpdateInfo.packageName)) {
                        try {
                            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(appUpdateInfo.packageName, 0);
                            com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo apkFileInfo = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo();
                            apkFileInfo.packageName = packageInfo.packageName;
                            apkFileInfo.apkId = appUpdateInfo.apkId;
                            apkFileInfo.fileCRC32 = new java.util.HashMap();
                            apkFileInfo.localVersionName = packageInfo.versionName;
                            apkFileInfo.localVersionCode = packageInfo.versionCode;
                            java.lang.String str2 = packageInfo.applicationInfo.sourceDir;
                            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "<ApkUpdateMessageHandler#getNeedUploadApk> pkg=" + packageInfo.packageName + ",localPath=" + str2);
                            apkFileInfo.manifestMd5 = com.tencent.yybsdk.apkpatch.f.e.b(str2);
                            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                            java.util.Map mapC = com.tencent.yybsdk.apkpatch.f.e.c(str2);
                            if (mapC.size() <= 0) {
                                str = "TMSelfUpdate_ApkUpdateSDKMessageHandler";
                                sb = new java.lang.StringBuilder();
                                sb.append("<ApkUpdateMessageHandler#getNeedUploadApk> fileMD5sOrCRCs.size() <= 0, pkg = ");
                                sb.append(packageInfo.packageName);
                            } else {
                                java.util.Map mapD = com.tencent.yybsdk.apkpatch.f.e.d(str2);
                                if (mapD.size() <= 0) {
                                    str = "TMSelfUpdate_ApkUpdateSDKMessageHandler";
                                    sb = new java.lang.StringBuilder();
                                    sb.append("<ApkUpdateMessageHandler#getNeedUploadApk> fileOffsets.size() <= 0, pkg = ");
                                    sb.append(packageInfo.packageName);
                                } else if (mapC.size() != mapD.size()) {
                                    str = "TMSelfUpdate_ApkUpdateSDKMessageHandler";
                                    sb = new java.lang.StringBuilder();
                                    sb.append("<ApkUpdateMessageHandler#getNeedUploadApk> fileMD5sOrCRCs.size() != fileOffsets.size(), pkg = ");
                                    sb.append(packageInfo.packageName);
                                } else {
                                    for (java.lang.String str3 : mapC.keySet()) {
                                        linkedHashMap.put(str3, new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.FileInfoV2((java.lang.String) mapC.get(str3), ((java.lang.Integer) mapD.get(str3)).intValue()));
                                    }
                                    apkFileInfo.fileInfos = linkedHashMap;
                                    this.e.put(apkFileInfo.packageName, apkFileInfo);
                                    com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_local_info_time_length", java.lang.String.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis), apkFileInfo.packageName);
                                }
                            }
                            com.tencent.tmassistantbase.util.TMLog.e(str, sb.toString());
                            break;
                        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                            com.tencent.tmassistantbase.util.TMLog.e("TAG", "exception:", e);
                        }
                    }
                }
                return this.e.size();
            }
        }
        return 0;
    }

    private synchronized void b() {
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "enter");
        if (this.e.size() <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i("TAG", "mNeedUploadApk.size() <= 0");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashMap map = this.e;
        arrayList.add((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo) map.get(map.keySet().iterator().next()));
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "startNewTask: UploadApkHttpRequest");
        com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().a(new com.tencent.tmapkupdatesdk.internal.logic.protocol.a.b(arrayList));
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "exit");
    }

    public void a(com.tencent.tmapkupdatesdk.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "enter");
        if (!this.c.contains(aVar)) {
            this.c.add(aVar);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "exit");
    }

    void a(java.util.List list) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "enter");
        if (list != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.content.pm.PackageManager packageManager = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b().getPackageManager();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.tmapkupdatesdk.ApkUpdateParam apkUpdateParam = (com.tencent.tmapkupdatesdk.ApkUpdateParam) it.next();
                java.lang.String str3 = apkUpdateParam.packageName;
                int i = apkUpdateParam.actionFlag;
                int i2 = apkUpdateParam.targetVersionCode;
                int i3 = apkUpdateParam.targetGrayVersionCode;
                if (!android.text.TextUtils.isEmpty(str3)) {
                    try {
                        android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str3, 0);
                        if (packageInfo != null) {
                            com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate appInfoForUpdate = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate();
                            appInfoForUpdate.packageName = str3;
                            appInfoForUpdate.versionCode = packageInfo.versionCode;
                            appInfoForUpdate.signatureMd5 = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b(str3);
                            java.lang.String lowerCase = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a(str3).toLowerCase();
                            appInfoForUpdate.manifestMd5 = lowerCase;
                            this.d.put(str3, lowerCase);
                            if ((packageInfo.applicationInfo.flags & 1) <= 0) {
                                appInfoForUpdate.appType = (byte) 1;
                            } else {
                                appInfoForUpdate.appType = (byte) 2;
                            }
                            appInfoForUpdate.versionName = packageInfo.versionName;
                            appInfoForUpdate.actionFlag = (byte) i;
                            appInfoForUpdate.grayVersionCode = com.tencent.tmapkupdatesdk.internal.c.a.a().a(str3);
                            appInfoForUpdate.targetVersionCode = i2;
                            appInfoForUpdate.targetGrayVersionCode = i3;
                            try {
                                appInfoForUpdate.cutEocdMd5 = com.tencent.yybsdk.apkpatch.f.e.b(com.tencent.tmassistantbase.util.k.a().b().getPackageManager().getPackageInfo(str3, 0).applicationInfo.sourceDir);
                            } catch (java.lang.Exception unused) {
                            }
                            arrayList.add(appInfoForUpdate);
                        }
                    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        com.tencent.tmassistantbase.util.TMLog.e("TAG", "exception:", e);
                    }
                }
            }
            com.tencent.tmassistantbase.util.TMLog.i("TAG", "updatecost=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            if (arrayList.size() > 0) {
                android.os.Message messageObtainMessage = a().obtainMessage();
                messageObtainMessage.what = 6;
                messageObtainMessage.obj = arrayList;
                messageObtainMessage.sendToTarget();
                str = "TAG";
                str2 = "send Message ApkUpdateMessageHandler.CheckUpdate";
            } else {
                android.os.Message messageObtainMessage2 = a().obtainMessage();
                messageObtainMessage2.what = 2;
                messageObtainMessage2.sendToTarget();
                str = "TAG";
                str2 = "send Message ApkUpdateMessageHandler.CheckUpdateFailed";
            }
            com.tencent.tmassistantbase.util.TMLog.i(str, str2);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "exit");
    }

    public void b(com.tencent.tmapkupdatesdk.a aVar) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.tmassistantbase.util.TMLog.i("TAG", "enter");
        if (aVar == null) {
            str = "TAG";
            str2 = "listener == null";
        } else {
            java.util.Iterator it = this.c.iterator();
            while (it.hasNext()) {
                if (((com.tencent.tmapkupdatesdk.a) it.next()) == aVar) {
                    it.remove();
                }
            }
            str = "TAG";
            str2 = "exit";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:1");
                java.util.Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    ((com.tencent.tmapkupdatesdk.a) it.next()).a((java.util.ArrayList) message.obj);
                }
                break;
            case 2:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:2");
                java.util.Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.tmapkupdatesdk.a) it2.next()).a("UNKOWN");
                }
                break;
            case 5:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:5");
                a((java.util.List) message.obj);
                break;
            case 6:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:6");
                com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().a(new com.tencent.tmapkupdatesdk.internal.logic.protocol.a.a((java.util.ArrayList) message.obj));
                break;
            case 7:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:7");
                if (b((java.util.ArrayList) message.obj) > 0) {
                    android.os.Message messageObtainMessage = a().obtainMessage();
                    messageObtainMessage.what = 8;
                    messageObtainMessage.obj = null;
                    messageObtainMessage.sendToTarget();
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "send Message ApkUpdateMessageHandler.UploadApkDetail");
                }
                break;
            case 8:
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkUpdateSDKMessageHandler", "message type:8");
                java.lang.Object obj = message.obj;
                if (obj != null) {
                    java.util.Iterator it3 = ((java.util.ArrayList) obj).iterator();
                    while (it3.hasNext()) {
                        a().e.remove((java.lang.String) it3.next());
                    }
                    if (a().e.isEmpty()) {
                    }
                }
                b();
                break;
        }
    }
}
