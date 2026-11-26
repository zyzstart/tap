package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RspHead extends com.qq.taf.jce.JceStruct {
    public int cmdId;
    public byte encryptWithPack;
    public java.lang.String phoneGuid;
    public int requestId;
    public int ret;

    public RspHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.ret = 0;
        this.encryptWithPack = (byte) 0;
        this.phoneGuid = "";
    }

    public RspHead(int i, int i2, int i3, byte b, java.lang.String str) {
        this.requestId = 0;
        this.cmdId = 0;
        this.ret = 0;
        this.encryptWithPack = (byte) 0;
        this.phoneGuid = "";
        this.requestId = i;
        this.cmdId = i2;
        this.ret = i3;
        this.encryptWithPack = b;
        this.phoneGuid = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.ret = jceInputStream.read(this.ret, 2, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 3, false);
        this.phoneGuid = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.ret, 2);
        jceOutputStream.write(this.encryptWithPack, 3);
        java.lang.String str = this.phoneGuid;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
