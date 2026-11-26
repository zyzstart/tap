package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Net extends com.qq.taf.jce.JceStruct {
    public java.lang.String extNetworkOperator;
    public int extNetworkType;
    public byte isWap;
    public byte netType;

    public Net() {
        this.netType = (byte) 0;
        this.extNetworkOperator = "";
        this.extNetworkType = 0;
        this.isWap = (byte) 0;
    }

    public Net(byte b, java.lang.String str, int i, byte b2) {
        this.netType = (byte) 0;
        this.extNetworkOperator = "";
        this.extNetworkType = 0;
        this.isWap = (byte) 0;
        this.netType = b;
        this.extNetworkOperator = str;
        this.extNetworkType = i;
        this.isWap = b2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.netType = jceInputStream.read(this.netType, 0, true);
        this.extNetworkOperator = jceInputStream.readString(1, false);
        this.extNetworkType = jceInputStream.read(this.extNetworkType, 2, false);
        this.isWap = jceInputStream.read(this.isWap, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.netType, 0);
        java.lang.String str = this.extNetworkOperator;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.extNetworkType, 2);
        jceOutputStream.write(this.isWap, 3);
    }
}
