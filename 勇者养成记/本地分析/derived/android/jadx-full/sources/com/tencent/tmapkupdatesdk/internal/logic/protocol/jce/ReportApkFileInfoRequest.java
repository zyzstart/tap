package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ReportApkFileInfoRequest extends com.qq.taf.jce.JceStruct {
    static java.util.ArrayList cache_apkFileInfoList = new java.util.ArrayList();
    public java.util.ArrayList apkFileInfoList;
    public int clientPatchCaps;

    static {
        cache_apkFileInfoList.add(new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkFileInfo());
    }

    public ReportApkFileInfoRequest() {
        this.apkFileInfoList = null;
        this.clientPatchCaps = 0;
    }

    public ReportApkFileInfoRequest(java.util.ArrayList arrayList, int i) {
        this.apkFileInfoList = null;
        this.clientPatchCaps = 0;
        this.apkFileInfoList = arrayList;
        this.clientPatchCaps = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.apkFileInfoList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_apkFileInfoList, 0, true);
        this.clientPatchCaps = jceInputStream.read(this.clientPatchCaps, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((java.util.Collection) this.apkFileInfoList, 0);
        jceOutputStream.write(this.clientPatchCaps, 1);
    }
}
