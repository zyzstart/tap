package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class InstalledStatLogInfo extends com.qq.taf.jce.JceStruct {
    public long appId;
    public java.lang.String channelId;
    public long downloadDate;
    public java.lang.String extradata;
    public java.lang.String sdkVersionInfo;
    public java.lang.String taskPackageName;
    public java.lang.String taskVersioncode;
    public long time;
    public byte type;
    public long uin;
    public java.lang.String uintype;
    public java.lang.String via;

    public InstalledStatLogInfo() {
        this.appId = 0L;
        this.taskPackageName = "";
        this.taskVersioncode = "";
        this.time = 0L;
        this.type = (byte) 0;
        this.uin = 0L;
        this.uintype = "";
        this.via = "";
        this.channelId = "";
        this.downloadDate = 0L;
        this.extradata = "";
        this.sdkVersionInfo = "";
    }

    public InstalledStatLogInfo(long j, java.lang.String str, java.lang.String str2, long j2, byte b, long j3, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j4, java.lang.String str6, java.lang.String str7) {
        this.appId = 0L;
        this.taskPackageName = "";
        this.taskVersioncode = "";
        this.time = 0L;
        this.type = (byte) 0;
        this.uin = 0L;
        this.uintype = "";
        this.via = "";
        this.channelId = "";
        this.downloadDate = 0L;
        this.extradata = "";
        this.sdkVersionInfo = "";
        this.appId = j;
        this.taskPackageName = str;
        this.taskVersioncode = str2;
        this.time = j2;
        this.type = b;
        this.uin = j3;
        this.uintype = str3;
        this.via = str4;
        this.channelId = str5;
        this.downloadDate = j4;
        this.extradata = str6;
        this.sdkVersionInfo = str7;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.taskPackageName = jceInputStream.readString(1, false);
        this.taskVersioncode = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
        this.type = jceInputStream.read(this.type, 4, false);
        this.uin = jceInputStream.read(this.uin, 5, false);
        this.uintype = jceInputStream.readString(6, false);
        this.via = jceInputStream.readString(7, false);
        this.channelId = jceInputStream.readString(8, false);
        this.downloadDate = jceInputStream.read(this.downloadDate, 9, false);
        this.extradata = jceInputStream.readString(10, false);
        this.sdkVersionInfo = jceInputStream.readString(11, false);
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
        jceOutputStream.write(this.time, 3);
        jceOutputStream.write(this.type, 4);
        jceOutputStream.write(this.uin, 5);
        java.lang.String str3 = this.uintype;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        java.lang.String str4 = this.via;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        java.lang.String str5 = this.channelId;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.downloadDate, 9);
        java.lang.String str6 = this.extradata;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        java.lang.String str7 = this.sdkVersionInfo;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
    }
}
