package com.tencent.tmapkupdatesdk.internal.logic.protocol.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.tmapkupdatesdk.internal.logic.protocol.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1000a = "TMSelfUpdate_UploadApkHttpRequest";
    private final java.util.List b;

    public b(java.util.List list) {
        this.b = list;
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void a() {
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, "<UploadApkHttpRequest#prepareData()> enter");
        super.a();
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoRequest reportApkFileInfoRequest = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoRequest();
        reportApkFileInfoRequest.apkFileInfoList = (java.util.ArrayList) this.b;
        reportApkFileInfoRequest.clientPatchCaps = 96;
        a(reportApkFileInfoRequest);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("prepareData; apkFileInfoList= [");
        for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo apkFileInfo : this.b) {
            try {
                stringBuffer.append("apkId=");
                stringBuffer.append(apkFileInfo.apkId);
                stringBuffer.append(", manifestMd5=");
                stringBuffer.append(apkFileInfo.manifestMd5);
                stringBuffer.append(", packageName=");
                stringBuffer.append(apkFileInfo.packageName);
                stringBuffer.append(", localVersionName=");
                stringBuffer.append(apkFileInfo.localVersionName);
                stringBuffer.append(", localVersionCode=");
                stringBuffer.append(apkFileInfo.localVersionCode);
                stringBuffer.append(", fileInfos size=");
                stringBuffer.append(apkFileInfo.fileInfos.keySet().size());
            } catch (java.lang.NullPointerException unused) {
                com.tencent.tmassistantbase.util.TMLog.e(f1000a, "<UploadApkHttpRequest#prepareData()> NullPointerException in apkFiles/fileInfos");
            }
        }
        stringBuffer.append("]");
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, stringBuffer.toString());
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, "<UploadApkHttpRequest#prepareData()> exit");
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void a(com.qq.taf.jce.JceStruct jceStruct, com.qq.taf.jce.JceStruct jceStruct2) {
        if (jceStruct2 == null || !(jceStruct2 instanceof com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoResponse)) {
            return;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoResponse reportApkFileInfoResponse = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoResponse) jceStruct2;
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, "onFinished; ret=" + reportApkFileInfoResponse.ret);
        if (reportApkFileInfoResponse.ret != 0) {
            b();
            return;
        }
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_local_info_upload_result", true, new java.lang.String[0]);
        android.os.Message messageObtainMessage = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
        messageObtainMessage.what = 3;
        messageObtainMessage.sendToTarget();
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, "send Message ApkUpdateMessageHandler.UploadApkDetailSucceed");
        if (jceStruct != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("reportedPackageNames = [");
            for (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo apkFileInfo : ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ReportApkFileInfoRequest) jceStruct).apkFileInfoList) {
                arrayList.add(apkFileInfo.packageName);
                stringBuffer.append("pkgname=" + apkFileInfo.packageName + ";");
            }
            com.tencent.tmassistantbase.util.TMLog.i(f1000a, stringBuffer.toString() + "]");
            if (arrayList.size() > 0) {
                android.os.Message messageObtainMessage2 = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
                messageObtainMessage2.what = 8;
                messageObtainMessage2.obj = arrayList;
                messageObtainMessage2.sendToTarget();
                com.tencent.tmassistantbase.util.TMLog.i(f1000a, "send Message ApkUpdateMessageHandler.UploadApkDetail");
            }
        }
    }

    @Override // com.tencent.tmapkupdatesdk.internal.logic.protocol.a
    protected void b() {
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_local_info_upload_result", false, new java.lang.String[0]);
        android.os.Message messageObtainMessage = com.tencent.tmapkupdatesdk.internal.logic.a.a().obtainMessage();
        messageObtainMessage.what = 4;
        messageObtainMessage.sendToTarget();
        com.tencent.tmassistantbase.util.TMLog.i(f1000a, "send Message ApkUpdateMessageHandler.UploadApkDetailFailed");
    }
}
