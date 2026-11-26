package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantCallYYBParamStruct {
    public java.lang.String SNGAppId;
    public java.lang.String actionFlag;
    public java.lang.String channelId;
    public java.lang.String cutEocdMd5;
    public java.lang.String taskApkId;
    public java.lang.String taskAppId;
    public java.lang.String taskPackageName;
    public int taskVersion;
    public java.lang.String uin;
    public java.lang.String uinType;
    public java.lang.String via;

    public TMAssistantCallYYBParamStruct() {
        this.SNGAppId = "";
        this.taskAppId = "";
        this.taskApkId = "";
        this.taskVersion = 0;
        this.via = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.channelId = "";
        this.cutEocdMd5 = "";
        this.actionFlag = "0";
    }

    public TMAssistantCallYYBParamStruct(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        this.SNGAppId = "";
        this.taskAppId = "";
        this.taskApkId = "";
        this.taskVersion = 0;
        this.via = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.channelId = "";
        this.cutEocdMd5 = "";
        this.actionFlag = "0";
        this.SNGAppId = str;
        this.taskAppId = str2;
        this.taskApkId = str3;
        this.taskVersion = i;
        this.via = str4;
        this.taskPackageName = str5;
        this.uin = str6;
        this.uinType = str7;
        this.channelId = str8;
        this.actionFlag = str9;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("SNGAppId = " + this.SNGAppId);
        sb.append(",taskAppId = " + this.taskAppId);
        sb.append(",taskApkId = " + this.taskApkId);
        sb.append(",taskVersion = " + this.taskVersion);
        sb.append(",via = " + this.via);
        sb.append(",taskPackageName = " + this.taskPackageName);
        sb.append(",uin = " + this.uin);
        sb.append(",uinType = " + this.uinType);
        sb.append(",channelId = " + this.channelId);
        sb.append(",actionFlag = " + this.actionFlag);
        return sb.toString();
    }
}
