package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BatchDownloadActionRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1100a;
    public java.util.ArrayList batchData;
    public int batchRequestType;
    public java.lang.String uin;
    public java.lang.String uinType;
    public java.lang.String via;

    public BatchDownloadActionRequest() {
        this.batchRequestType = 0;
        this.batchData = null;
        this.uin = "";
        this.uinType = "";
        this.via = "";
    }

    public BatchDownloadActionRequest(int i, java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.batchRequestType = 0;
        this.batchData = null;
        this.uin = "";
        this.uinType = "";
        this.via = "";
        this.batchRequestType = i;
        this.batchData = arrayList;
        this.uin = str;
        this.uinType = str2;
        this.via = str3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (f1100a == null) {
            f1100a = new java.util.ArrayList();
            f1100a.add(new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam());
        }
        this.batchData = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1100a, 1, false);
        this.uin = jceInputStream.readString(2, false);
        this.uinType = jceInputStream.readString(3, false);
        this.via = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchRequestType, 0);
        java.util.ArrayList arrayList = this.batchData;
        if (arrayList != null) {
            jceOutputStream.write((java.util.Collection) arrayList, 1);
        }
        java.lang.String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        java.lang.String str2 = this.uinType;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        java.lang.String str3 = this.via;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }
}
