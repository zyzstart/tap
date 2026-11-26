package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetHotSdkUpdateResponse extends com.qq.taf.jce.JceStruct {
    public long netType;
    public int patchBuilderNum;
    public java.lang.String patchMD5;
    public int patchSdkVersion;
    public long patchSize;
    public java.lang.String patchUrl;
    public int ret;

    public GetHotSdkUpdateResponse() {
        this.ret = 0;
        this.patchUrl = "";
        this.patchMD5 = "";
        this.patchSize = 0L;
        this.patchSdkVersion = 0;
        this.netType = 0L;
        this.patchBuilderNum = 0;
    }

    public GetHotSdkUpdateResponse(int i, java.lang.String str, java.lang.String str2, long j, int i2, long j2, int i3) {
        this.ret = 0;
        this.patchUrl = "";
        this.patchMD5 = "";
        this.patchSize = 0L;
        this.patchSdkVersion = 0;
        this.netType = 0L;
        this.patchBuilderNum = 0;
        this.ret = i;
        this.patchUrl = str;
        this.patchMD5 = str2;
        this.patchSize = j;
        this.patchSdkVersion = i2;
        this.netType = j2;
        this.patchBuilderNum = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.patchUrl = jceInputStream.readString(1, false);
        this.patchMD5 = jceInputStream.readString(2, false);
        this.patchSize = jceInputStream.read(this.patchSize, 3, false);
        this.patchSdkVersion = jceInputStream.read(this.patchSdkVersion, 4, false);
        this.netType = jceInputStream.read(this.netType, 5, false);
        this.patchBuilderNum = jceInputStream.read(this.patchBuilderNum, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        java.lang.String str = this.patchUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        java.lang.String str2 = this.patchMD5;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.patchSize, 3);
        jceOutputStream.write(this.patchSdkVersion, 4);
        jceOutputStream.write(this.netType, 5);
        jceOutputStream.write(this.patchBuilderNum, 6);
    }
}
