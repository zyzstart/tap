package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BatchDownloadActionResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1101a;
    public java.util.ArrayList batchData;
    public int batchRequestType;

    public BatchDownloadActionResponse() {
        this.batchRequestType = 0;
        this.batchData = null;
    }

    public BatchDownloadActionResponse(int i, java.util.ArrayList arrayList) {
        this.batchRequestType = 0;
        this.batchData = null;
        this.batchRequestType = i;
        this.batchData = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (f1101a == null) {
            f1101a = new java.util.ArrayList();
            f1101a.add(new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo());
        }
        this.batchData = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1101a, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchRequestType, 0);
        java.util.ArrayList arrayList = this.batchData;
        if (arrayList != null) {
            jceOutputStream.write((java.util.Collection) arrayList, 1);
        }
    }
}
