package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Terminal extends com.qq.taf.jce.JceStruct {
    public java.lang.String androidId;
    public java.lang.String androidIdSdCard;
    public java.lang.String imei;
    public java.lang.String imsi;
    public java.lang.String macAdress;

    public Terminal() {
        this.imei = "";
        this.macAdress = "";
        this.androidId = "";
        this.androidIdSdCard = "";
        this.imsi = "";
    }

    public Terminal(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.imei = "";
        this.macAdress = "";
        this.androidId = "";
        this.androidIdSdCard = "";
        this.imsi = "";
        this.imei = str;
        this.macAdress = str2;
        this.androidId = str3;
        this.androidIdSdCard = str4;
        this.imsi = str5;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.macAdress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.androidIdSdCard = jceInputStream.readString(3, false);
        this.imsi = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        java.lang.String str2 = this.macAdress;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        java.lang.String str3 = this.androidId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        java.lang.String str4 = this.androidIdSdCard;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        java.lang.String str5 = this.imsi;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }
}
