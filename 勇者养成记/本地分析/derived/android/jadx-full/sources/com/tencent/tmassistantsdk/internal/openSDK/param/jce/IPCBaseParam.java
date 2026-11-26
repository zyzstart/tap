package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCBaseParam extends com.qq.taf.jce.JceStruct {
    public java.lang.String channelId;
    public java.lang.String extra;
    public java.lang.String hostAppId;
    public java.lang.String taskAppId;
    public java.lang.String taskPackageName;
    public java.lang.String taskVersion;
    public java.lang.String uin;
    public java.lang.String uinType;
    public java.lang.String via;

    public IPCBaseParam() {
        this.hostAppId = "";
        this.taskAppId = "";
        this.taskVersion = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.via = "";
        this.channelId = "";
        this.extra = "";
    }

    public IPCBaseParam(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        this.hostAppId = "";
        this.taskAppId = "";
        this.taskVersion = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.via = "";
        this.channelId = "";
        this.extra = "";
        this.hostAppId = str;
        this.taskAppId = str2;
        this.taskVersion = str3;
        this.taskPackageName = str4;
        this.uin = str5;
        this.uinType = str6;
        this.via = str7;
        this.channelId = str8;
        this.extra = str9;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.hostAppId = jceInputStream.readString(0, true);
        this.taskAppId = jceInputStream.readString(1, false);
        this.taskVersion = jceInputStream.readString(2, true);
        this.taskPackageName = jceInputStream.readString(3, true);
        this.uin = jceInputStream.readString(4, false);
        this.uinType = jceInputStream.readString(5, false);
        this.via = jceInputStream.readString(6, false);
        this.channelId = jceInputStream.readString(7, false);
        this.extra = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hostAppId, 0);
        java.lang.String str = this.taskAppId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.taskVersion, 2);
        jceOutputStream.write(this.taskPackageName, 3);
        java.lang.String str2 = this.uin;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        java.lang.String str3 = this.uinType;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        java.lang.String str4 = this.via;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        java.lang.String str5 = this.channelId;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        java.lang.String str6 = this.extra;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
    }
}
