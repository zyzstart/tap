package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class OperateDownloadTaskRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam f1108a;
    public java.lang.String actionFlag;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam baseParam;
    public java.lang.String opList;
    public int requestType;
    public java.lang.String verifyType;

    public OperateDownloadTaskRequest() {
        this.requestType = 0;
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
    }

    public OperateDownloadTaskRequest(int i, com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.requestType = 0;
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
        this.requestType = i;
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.requestType = jceInputStream.read(this.requestType, 0, true);
        if (f1108a == null) {
            f1108a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        }
        this.baseParam = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam) jceInputStream.read((com.qq.taf.jce.JceStruct) f1108a, 1, true);
        this.opList = jceInputStream.readString(2, false);
        this.actionFlag = jceInputStream.readString(3, false);
        this.verifyType = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestType, 0);
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.baseParam, 1);
        java.lang.String str = this.opList;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        java.lang.String str2 = this.actionFlag;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        java.lang.String str3 = this.verifyType;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }
}
