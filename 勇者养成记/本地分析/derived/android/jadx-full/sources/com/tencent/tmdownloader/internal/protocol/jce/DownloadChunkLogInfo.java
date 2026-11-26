package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DownloadChunkLogInfo extends com.qq.taf.jce.JceStruct {
    public java.lang.String UUID;
    public java.lang.String appId;
    public byte currentRetryCnt;
    public long endTime;
    public int errorCode;
    public java.lang.String flag;
    public byte isWap;
    public java.lang.String networkOperator;
    public int networkType;
    public long readHeaderTime;
    public long receiveDataSize;
    public long requestRanagePosition;
    public long requestRanageSize;
    public java.lang.String requestUrl;
    public long responseContentLength;
    public int responseHttpCode;
    public long responseRangeLength;
    public long responseRangePosition;
    public int resultState;
    public long startTime;
    public byte type;
    public java.lang.String via;

    public DownloadChunkLogInfo() {
        this.UUID = "";
        this.type = (byte) 0;
        this.requestUrl = "";
        this.networkOperator = "";
        this.networkType = 0;
        this.isWap = (byte) 0;
        this.requestRanagePosition = 0L;
        this.requestRanageSize = 0L;
        this.responseRangePosition = 0L;
        this.responseRangeLength = 0L;
        this.responseContentLength = 0L;
        this.responseHttpCode = 0;
        this.receiveDataSize = 0L;
        this.startTime = 0L;
        this.readHeaderTime = 0L;
        this.endTime = 0L;
        this.errorCode = 0;
        this.resultState = 0;
        this.currentRetryCnt = (byte) 0;
        this.via = "";
        this.appId = "";
        this.flag = "";
    }

    public DownloadChunkLogInfo(java.lang.String str, byte b, java.lang.String str2, java.lang.String str3, int i, byte b2, long j, long j2, long j3, long j4, long j5, int i2, long j6, long j7, long j8, long j9, int i3, int i4, byte b3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.UUID = "";
        this.type = (byte) 0;
        this.requestUrl = "";
        this.networkOperator = "";
        this.networkType = 0;
        this.isWap = (byte) 0;
        this.requestRanagePosition = 0L;
        this.requestRanageSize = 0L;
        this.responseRangePosition = 0L;
        this.responseRangeLength = 0L;
        this.responseContentLength = 0L;
        this.responseHttpCode = 0;
        this.receiveDataSize = 0L;
        this.startTime = 0L;
        this.readHeaderTime = 0L;
        this.endTime = 0L;
        this.errorCode = 0;
        this.resultState = 0;
        this.currentRetryCnt = (byte) 0;
        this.via = "";
        this.appId = "";
        this.flag = "";
        this.UUID = str;
        this.type = b;
        this.requestUrl = str2;
        this.networkOperator = str3;
        this.networkType = i;
        this.isWap = b2;
        this.requestRanagePosition = j;
        this.requestRanageSize = j2;
        this.responseRangePosition = j3;
        this.responseRangeLength = j4;
        this.responseContentLength = j5;
        this.responseHttpCode = i2;
        this.receiveDataSize = j6;
        this.startTime = j7;
        this.readHeaderTime = j8;
        this.endTime = j9;
        this.errorCode = i3;
        this.resultState = i4;
        this.currentRetryCnt = b3;
        this.via = str4;
        this.appId = str5;
        this.flag = str6;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.UUID = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.requestUrl = jceInputStream.readString(2, false);
        this.networkOperator = jceInputStream.readString(3, false);
        this.networkType = jceInputStream.read(this.networkType, 4, false);
        this.isWap = jceInputStream.read(this.isWap, 5, false);
        this.requestRanagePosition = jceInputStream.read(this.requestRanagePosition, 6, false);
        this.requestRanageSize = jceInputStream.read(this.requestRanageSize, 7, false);
        this.responseRangePosition = jceInputStream.read(this.responseRangePosition, 9, false);
        this.responseRangeLength = jceInputStream.read(this.responseRangeLength, 10, false);
        this.responseContentLength = jceInputStream.read(this.responseContentLength, 11, false);
        this.responseHttpCode = jceInputStream.read(this.responseHttpCode, 12, false);
        this.receiveDataSize = jceInputStream.read(this.receiveDataSize, 13, false);
        this.startTime = jceInputStream.read(this.startTime, 14, false);
        this.readHeaderTime = jceInputStream.read(this.readHeaderTime, 15, false);
        this.endTime = jceInputStream.read(this.endTime, 16, false);
        this.errorCode = jceInputStream.read(this.errorCode, 17, false);
        this.resultState = jceInputStream.read(this.resultState, 18, false);
        this.currentRetryCnt = jceInputStream.read(this.currentRetryCnt, 19, false);
        this.via = jceInputStream.readString(20, false);
        this.appId = jceInputStream.readString(21, false);
        this.flag = jceInputStream.readString(22, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.UUID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.type, 1);
        java.lang.String str2 = this.requestUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        java.lang.String str3 = this.networkOperator;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.networkType, 4);
        jceOutputStream.write(this.isWap, 5);
        jceOutputStream.write(this.requestRanagePosition, 6);
        jceOutputStream.write(this.requestRanageSize, 7);
        jceOutputStream.write(this.responseRangePosition, 9);
        jceOutputStream.write(this.responseRangeLength, 10);
        jceOutputStream.write(this.responseContentLength, 11);
        jceOutputStream.write(this.responseHttpCode, 12);
        jceOutputStream.write(this.receiveDataSize, 13);
        jceOutputStream.write(this.startTime, 14);
        jceOutputStream.write(this.readHeaderTime, 15);
        jceOutputStream.write(this.endTime, 16);
        jceOutputStream.write(this.errorCode, 17);
        jceOutputStream.write(this.resultState, 18);
        jceOutputStream.write(this.currentRetryCnt, 19);
        java.lang.String str4 = this.via;
        if (str4 != null) {
            jceOutputStream.write(str4, 20);
        }
        java.lang.String str5 = this.appId;
        if (str5 != null) {
            jceOutputStream.write(str5, 21);
        }
        java.lang.String str6 = this.flag;
        if (str6 != null) {
            jceOutputStream.write(str6, 22);
        }
    }
}
