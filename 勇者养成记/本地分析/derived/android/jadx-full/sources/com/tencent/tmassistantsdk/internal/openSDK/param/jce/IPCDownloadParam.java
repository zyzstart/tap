package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCDownloadParam extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam f1105a;
    public java.lang.String actionFlag;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam baseParam;
    public java.lang.String opList;
    public java.lang.String reverse;
    public java.lang.String verifyType;

    public IPCDownloadParam() {
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
        this.reverse = "";
    }

    public IPCDownloadParam(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
        this.reverse = "";
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
        this.reverse = str4;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1105a == null) {
            f1105a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        }
        this.baseParam = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam) jceInputStream.read((com.qq.taf.jce.JceStruct) f1105a, 0, true);
        this.opList = jceInputStream.readString(1, false);
        this.actionFlag = jceInputStream.readString(2, false);
        this.verifyType = jceInputStream.readString(3, false);
        this.reverse = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.baseParam, 0);
        java.lang.String str = this.opList;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        java.lang.String str2 = this.actionFlag;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        java.lang.String str3 = this.verifyType;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        java.lang.String str4 = this.reverse;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }
}
