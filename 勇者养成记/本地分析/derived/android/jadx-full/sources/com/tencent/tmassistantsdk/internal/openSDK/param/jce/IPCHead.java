package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCHead extends com.qq.taf.jce.JceStruct {
    public int cmdId;
    public java.lang.String hostPackageName;
    public java.lang.String hostVersionCode;
    public int requestId;
    public java.lang.String traceId;

    public IPCHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.hostPackageName = "";
        this.hostVersionCode = "";
        this.traceId = "";
    }

    public IPCHead(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.requestId = 0;
        this.cmdId = 0;
        this.hostPackageName = "";
        this.hostVersionCode = "";
        this.traceId = "";
        this.requestId = i;
        this.cmdId = i2;
        this.hostPackageName = str;
        this.hostVersionCode = str2;
        this.traceId = str3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.hostPackageName = jceInputStream.readString(2, true);
        this.hostVersionCode = jceInputStream.readString(3, true);
        this.traceId = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.hostPackageName, 2);
        jceOutputStream.write(this.hostVersionCode, 3);
        java.lang.String str = this.traceId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
