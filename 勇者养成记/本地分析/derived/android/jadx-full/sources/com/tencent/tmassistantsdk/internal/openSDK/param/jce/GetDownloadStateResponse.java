package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetDownloadStateResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam f1103a;
    public int errorCode;
    public java.lang.String errorMsg;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam requestParam;
    public int state;

    public GetDownloadStateResponse() {
        this.requestParam = null;
        this.state = 0;
        this.errorCode = 0;
        this.errorMsg = "";
    }

    public GetDownloadStateResponse(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam, int i, int i2, java.lang.String str) {
        this.requestParam = null;
        this.state = 0;
        this.errorCode = 0;
        this.errorMsg = "";
        this.requestParam = iPCBaseParam;
        this.state = i;
        this.errorCode = i2;
        this.errorMsg = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1103a == null) {
            f1103a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        }
        this.requestParam = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam) jceInputStream.read((com.qq.taf.jce.JceStruct) f1103a, 0, true);
        this.state = jceInputStream.read(this.state, 1, false);
        this.errorCode = jceInputStream.read(this.errorCode, 2, false);
        this.errorMsg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.state, 1);
        jceOutputStream.write(this.errorCode, 2);
        java.lang.String str = this.errorMsg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }
}
