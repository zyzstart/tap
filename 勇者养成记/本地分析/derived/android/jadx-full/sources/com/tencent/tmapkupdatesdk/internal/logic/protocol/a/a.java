package com.tencent.tmapkupdatesdk.internal.logic.protocol.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmapkupdatesdk.internal.logic.protocol.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f999a = "TMSelfUpdate_CheckAppUpdateHttpRequest";
    private final java.util.List b;

    public a(java.util.List list) {
        this.b = list;
    }

    public static java.lang.String a(com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("packageName: " + appUpdateInfo.packageName + '\n');
        sb.append("appName: " + appUpdateInfo.appName + '\n');
        sb.append("versionCode: " + appUpdateInfo.versionCode + '\n');
        sb.append("iconUrl: " + appUpdateInfo.iconUrl + '\n');
        sb.append("newFeature: " + appUpdateInfo.newFeature + '\n');
        sb.append("apkMd5: " + appUpdateInfo.apkMd5 + '\n');
        sb.append("fileSize: " + appUpdateInfo.fileSize + '\n');
        sb.append("diffApkMd5: " + appUpdateInfo.diffApkMd5 + '\n');
        sb.append("diffApkUrl: " + appUpdateInfo.diffApkUrl + '\n');
        sb.append("diffFileSize: " + appUpdateInfo.diffFileSize + '\n');
        sb.append("versionName: " + appUpdateInfo.versionName + '\n');
        sb.append("patchAlgorithm: " + ((int) appUpdateInfo.patchAlgorithm) + '\n');
        sb.append("overwriteChannelid: " + ((int) appUpdateInfo.overwriteChannelid) + '\n');
        sb.append("apkUrl: " + appUpdateInfo.apkUrl + '\n');
        sb.append("appId: " + appUpdateInfo.appId + '\n');
        sb.append("flag: " + appUpdateInfo.flag + '\n');
        sb.append("apkDownUrl: " + appUpdateInfo.apkDownUrl + '\n');
        return sb.toString();
    }

    private com.tencent.tmapkupdatesdk.model.ApkUpdateDetail b(com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo) {
        boolean z;
        com.tencent.tmassistantbase.util.TMLog.i(f999a, "convert AppUpdateInfo To Detail,original updateinfo: ");
        com.tencent.tmassistantbase.util.TMLog.i(f999a, a(appUpdateInfo));
        if (appUpdateInfo == null) {
            return null;
        }
        com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail = new com.tencent.tmapkupdatesdk.model.ApkUpdateDetail();
        apkUpdateDetail.packageName = appUpdateInfo.packageName;
        apkUpdateDetail.versionname = appUpdateInfo.versionName;
        apkUpdateDetail.versioncode = appUpdateInfo.versionCode;
        java.util.ArrayList<com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl> arrayList = appUpdateInfo.apkDownUrl;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            java.util.Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl apkDownUrl = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl) it.next();
                    if (apkDownUrl != null) {
                        byte b = apkDownUrl.type;
                        if (b == 2) {
                            java.util.ArrayList arrayList2 = apkDownUrl.urlList;
                            java.lang.String str = arrayList2 != null ? (java.lang.String) arrayList2.get(0) : "";
                            apkUpdateDetail.updatemethod = 4;
                            apkUpdateDetail.url = str;
                        } else if (b == 32 || b == 64) {
                            java.util.ArrayList arrayList3 = apkDownUrl.urlList;
                            java.lang.String str2 = arrayList3 != null ? (java.lang.String) arrayList3.get(0) : "";
                            apkUpdateDetail.patchsize = (int) apkDownUrl.diffFileSize;
                            apkUpdateDetail.fileMd5 = apkDownUrl.diffApkMd5;
                            apkUpdateDetail.updatemethod = 5;
                            apkUpdateDetail.url = str2;
                            apkUpdateDetail.patchAlgorithm = apkDownUrl.type;
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        if (!z && arrayList != null && arrayList.size() > 0) {
            for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl apkDownUrl2 : arrayList) {
                if (apkDownUrl2 != null && apkDownUrl2.type == 1) {
                    java.util.ArrayList arrayList4 = apkDownUrl2.urlList;
                    java.lang.String str3 = arrayList4 != null ? (java.lang.String) arrayList4.get(0) : "";
                    apkUpdateDetail.updatemethod = 2;
                    apkUpdateDetail.url = str3;
                    break;
                }
            }
        }
        apkUpdateDetail.newapksize = (int) appUpdateInfo.fileSize;
        if (apkUpdateDetail.patchsize <= 0) {
            apkUpdateDetail.patchsize = (int) appUpdateInfo.diffFileSize;
        }
        if (android.text.TextUtils.isEmpty(apkUpdateDetail.fileMd5)) {
            apkUpdateDetail.fileMd5 = appUpdateInfo.diffApkMd5;
        }
        apkUpdateDetail.sigMd5 = appUpdateInfo.signatureMd5;
        apkUpdateDetail.newFeature = appUpdateInfo.newFeature;
        apkUpdateDetail.overwriteChannelid = appUpdateInfo.overwriteChannelid;
        apkUpdateDetail.appId = appUpdateInfo.appId;
        apkUpdateDetail.apkId = appUpdateInfo.apkId;
        return apkUpdateDetail;
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void a() {
        com.tencent.tmassistantbase.util.TMLog.i(f999a, "enter");
        super.a();
        if (this.b != null) {
            com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest getAppUpdateRequest = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest();
            getAppUpdateRequest.appInfoForUpdateList = (java.util.ArrayList) this.b;
            getAppUpdateRequest.flag = (byte) 0;
            getAppUpdateRequest.clientPatchCaps = (short) 96;
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("appInfoForUpdateList= [");
            for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate appInfoForUpdate : this.b) {
                stringBuffer.append("pkgname=" + appInfoForUpdate.packageName + ";versionCode=" + appInfoForUpdate.versionCode + ";targetVersionCode=" + appInfoForUpdate.targetVersionCode + ";targetGrayVersionCode=" + appInfoForUpdate.targetGrayVersionCode + "| \n\r");
            }
            com.tencent.tmassistantbase.util.TMLog.i(f999a, stringBuffer.toString() + "]");
            a(getAppUpdateRequest);
        }
        com.tencent.tmassistantbase.util.TMLog.i(f999a, "exit");
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void a(com.qq.taf.jce.JceStruct jceStruct, com.qq.taf.jce.JceStruct jceStruct2) {
        com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail;
        boolean z;
        java.util.Collection<java.util.ArrayList> collectionValues;
        if (jceStruct2 == null || !(jceStruct2 instanceof com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse)) {
            return;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse getAppUpdateResponse = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse) jceStruct2;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("response=  [");
        stringBuffer.append("ret=" + getAppUpdateResponse.ret + "| ");
        if (getAppUpdateResponse.ret != 0) {
            com.tencent.tmassistantbase.util.TMLog.i(f999a, "checkAppUpdate fail");
            b();
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(f999a, "checkAppUpdate success");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo> arrayList2 = new java.util.ArrayList();
        java.util.Map map = getAppUpdateResponse.appUpdateInfoGroup;
        if (map != null && map.size() > 0 && (collectionValues = map.values()) != null && collectionValues.size() > 0) {
            for (java.util.ArrayList<com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo> arrayList3 : collectionValues) {
                if (arrayList3 != null && arrayList3.size() > 0) {
                    for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo : arrayList3) {
                        int i = appUpdateInfo.flag;
                        if (com.tencent.tmapkupdatesdk.internal.c.b.a(i, 0)) {
                            arrayList2.add(appUpdateInfo);
                        }
                        stringBuffer.append("pkgname=" + appUpdateInfo.packageName + ";versionCode=" + appUpdateInfo.versionCode + ";uploadFlag=" + com.tencent.tmapkupdatesdk.internal.c.b.a(i, 0) + ";overwriteChannelid=" + ((int) appUpdateInfo.overwriteChannelid) + "| \n\r");
                        com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetailB = b(appUpdateInfo);
                        if (apkUpdateDetailB != null) {
                            java.lang.String strB = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b(apkUpdateDetailB.packageName);
                            boolean z2 = com.tencent.tmapkupdatesdk.internal.c.a.a().b() != null && com.tencent.tmapkupdatesdk.internal.c.a.a(com.tencent.tmapkupdatesdk.internal.c.a.a().b(), apkUpdateDetailB.packageName) == apkUpdateDetailB.versioncode;
                            if (strB.compareToIgnoreCase(apkUpdateDetailB.sigMd5) != 0 || z2) {
                                apkUpdateDetailB.updatemethod = 1;
                            }
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "packageName: " + apkUpdateDetailB.packageName);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "updatemethod: " + apkUpdateDetailB.updatemethod);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "newapksize: " + apkUpdateDetailB.newapksize);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "patchsize: " + apkUpdateDetailB.patchsize);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "url: " + apkUpdateDetailB.url);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "overwriteChannelid: " + ((int) apkUpdateDetailB.overwriteChannelid));
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "newFeature: " + apkUpdateDetailB.newFeature);
                            com.tencent.tmassistantbase.util.TMLog.i(f999a, "patchAlgorithm: " + ((int) apkUpdateDetailB.patchAlgorithm));
                            arrayList.add(apkUpdateDetailB);
                            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_check_update_result", true, java.lang.String.valueOf(apkUpdateDetailB.updatemethod), apkUpdateDetailB.packageName, java.lang.String.valueOf(apkUpdateDetailB.versioncode));
                        }
                    }
                }
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(f999a, stringBuffer.toString() + "]");
        java.util.ArrayList<com.tencent.tmapkupdatesdk.model.ApkUpdateDetail> arrayList4 = new java.util.ArrayList();
        java.util.List<com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate> list = this.b;
        if (list != null) {
            for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate appInfoForUpdate : list) {
                java.lang.String str = appInfoForUpdate.packageName;
                int i2 = appInfoForUpdate.versionCode;
                java.lang.String str2 = appInfoForUpdate.versionName;
                java.util.Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        apkUpdateDetail = null;
                        z = false;
                        break;
                    }
                    apkUpdateDetail = (com.tencent.tmapkupdatesdk.model.ApkUpdateDetail) it.next();
                    java.lang.String str3 = apkUpdateDetail.packageName;
                    if (str != null && str3 != null && str.equals(str3)) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    arrayList4.add(apkUpdateDetail);
                } else {
                    com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail2 = new com.tencent.tmapkupdatesdk.model.ApkUpdateDetail();
                    apkUpdateDetail2.packageName = str;
                    apkUpdateDetail2.versionname = str2;
                    apkUpdateDetail2.versioncode = i2;
                    apkUpdateDetail2.updatemethod = 1;
                    arrayList4.add(apkUpdateDetail2);
                }
            }
        }
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer("returnSuceessList = [");
        for (com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail3 : arrayList4) {
            stringBuffer2.append("pkgname=" + apkUpdateDetail3.packageName + ";versionCode=" + apkUpdateDetail3.versioncode + "| \n\r");
        }
        com.tencent.tmassistantbase.util.TMLog.i(f999a, stringBuffer2.toString() + "]");
        android.os.Message messageObtainMessage = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = arrayList4;
        messageObtainMessage.sendToTarget();
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer("needUpdateApkInfos = [");
        for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo2 : arrayList2) {
            stringBuffer3.append("pkgname=" + appUpdateInfo2.packageName + ";versionCode=" + appUpdateInfo2.versionCode + ";grayVersionCode=" + appUpdateInfo2.grayVersionCode + "| \n\r");
        }
        com.tencent.tmassistantbase.util.TMLog.i(f999a, stringBuffer3.toString() + "]");
        if (arrayList2.size() > 0) {
            android.os.Message messageObtainMessage2 = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
            messageObtainMessage2.what = 7;
            messageObtainMessage2.obj = arrayList2;
            messageObtainMessage2.sendToTarget();
            com.tencent.tmassistantbase.util.TMLog.i(f999a, "send Message ApkUpdateMessageHandler.GetNeedUpdateApk");
        }
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void b() {
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_check_update_result", false, new java.lang.String[0]);
        android.os.Message messageObtainMessage = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.sendToTarget();
        com.tencent.tmassistantbase.util.TMLog.i(f999a, "send Message ApkUpdateMessageHandler.CheckUpdateFailed");
    }
}
