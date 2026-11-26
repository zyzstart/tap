package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DownloadStatLogInfo extends com.qq.taf.jce.JceStruct {
    public long appId;
    public java.lang.String channelId;
    public java.lang.String clientIp;
    public byte downType;
    public long endTime;
    public int errorCode;
    public java.lang.String extradata;
    public long reportTime;
    public byte result;
    public java.lang.String sdkVersionInfo;
    public long starTime;
    public java.lang.String taskPackageName;
    public java.lang.String taskVersioncode;
    public long totalFileSize;
    public java.lang.String traceId;
    public long uin;
    public java.lang.String uintype;
    public java.lang.String via;

    public DownloadStatLogInfo() {
        this.appId = 0L;
        this.taskPackageName = "";
        this.taskVersioncode = "";
        this.clientIp = "";
        this.starTime = 0L;
        this.endTime = 0L;
        this.totalFileSize = 0L;
        this.result = (byte) 0;
        this.downType = (byte) 0;
        this.errorCode = 0;
        this.uin = 0L;
        this.uintype = "";
        this.via = "";
        this.channelId = "";
        this.sdkVersionInfo = "";
        this.reportTime = 0L;
        this.traceId = "";
        this.extradata = "";
    }

    public DownloadStatLogInfo(long j, java.lang.String str, java.lang.String str2, java.lang.String str3, long j2, long j3, long j4, byte b, byte b2, int i, long j5, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, long j6, java.lang.String str8, java.lang.String str9) {
        this.appId = 0L;
        this.taskPackageName = "";
        this.taskVersioncode = "";
        this.clientIp = "";
        this.starTime = 0L;
        this.endTime = 0L;
        this.totalFileSize = 0L;
        this.result = (byte) 0;
        this.downType = (byte) 0;
        this.errorCode = 0;
        this.uin = 0L;
        this.uintype = "";
        this.via = "";
        this.channelId = "";
        this.sdkVersionInfo = "";
        this.reportTime = 0L;
        this.traceId = "";
        this.extradata = "";
        this.appId = j;
        this.taskPackageName = str;
        this.taskVersioncode = str2;
        this.clientIp = str3;
        this.starTime = j2;
        this.endTime = j3;
        this.totalFileSize = j4;
        this.result = b;
        this.downType = b2;
        this.errorCode = i;
        this.uin = j5;
        this.uintype = str4;
        this.via = str5;
        this.channelId = str6;
        this.sdkVersionInfo = str7;
        this.reportTime = j6;
        this.traceId = str8;
        this.extradata = str9;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.taskPackageName = jceInputStream.readString(1, false);
        this.taskVersioncode = jceInputStream.readString(2, false);
        this.clientIp = jceInputStream.readString(3, false);
        this.starTime = jceInputStream.read(this.starTime, 4, false);
        this.endTime = jceInputStream.read(this.endTime, 5, false);
        this.totalFileSize = jceInputStream.read(this.totalFileSize, 6, false);
        this.result = jceInputStream.read(this.result, 7, false);
        this.downType = jceInputStream.read(this.downType, 8, false);
        this.errorCode = jceInputStream.read(this.errorCode, 9, false);
        this.uin = jceInputStream.read(this.uin, 10, false);
        this.uintype = jceInputStream.readString(11, false);
        this.via = jceInputStream.readString(12, false);
        this.channelId = jceInputStream.readString(13, false);
        this.sdkVersionInfo = jceInputStream.readString(14, false);
        this.reportTime = jceInputStream.read(this.reportTime, 15, false);
        this.traceId = jceInputStream.readString(16, false);
        this.extradata = jceInputStream.readString(17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appId, 0);
        java.lang.String str = this.taskPackageName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        java.lang.String str2 = this.taskVersioncode;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        java.lang.String str3 = this.clientIp;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.starTime, 4);
        jceOutputStream.write(this.endTime, 5);
        jceOutputStream.write(this.totalFileSize, 6);
        jceOutputStream.write(this.result, 7);
        jceOutputStream.write(this.downType, 8);
        jceOutputStream.write(this.errorCode, 9);
        jceOutputStream.write(this.uin, 10);
        java.lang.String str4 = this.uintype;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        java.lang.String str5 = this.via;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        java.lang.String str6 = this.channelId;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        java.lang.String str7 = this.sdkVersionInfo;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.reportTime, 15);
        java.lang.String str8 = this.traceId;
        if (str8 != null) {
            jceOutputStream.write(str8, 16);
        }
        java.lang.String str9 = this.extradata;
        if (str9 != null) {
            jceOutputStream.write(str9, 17);
        }
    }
}
