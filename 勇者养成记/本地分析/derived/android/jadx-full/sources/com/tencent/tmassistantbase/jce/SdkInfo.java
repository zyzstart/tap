package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class SdkInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1036a = !com.tencent.tmassistantbase.jce.SdkInfo.class.desiredAssertionStatus();
    public java.lang.String builderNum;
    public java.lang.String channel;
    public java.lang.String name;
    public java.lang.String subChannel;
    public int versionCode;
    public java.lang.String versionName;

    public SdkInfo() {
        this.name = "";
        this.versionName = "";
        this.versionCode = 0;
        this.channel = "";
        this.subChannel = "";
        this.builderNum = "";
    }

    public SdkInfo(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.name = "";
        this.versionName = "";
        this.versionCode = 0;
        this.channel = "";
        this.subChannel = "";
        this.builderNum = "";
        this.name = str;
        this.versionName = str2;
        this.versionCode = i;
        this.channel = str3;
        this.subChannel = str4;
        this.builderNum = str5;
    }

    public java.lang.String className() {
        return "SDKSys.SdkInfo";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (f1036a) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.name, "name");
        jceDisplayer.display(this.versionName, "versionName");
        jceDisplayer.display(this.versionCode, "versionCode");
        jceDisplayer.display(this.channel, com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL);
        jceDisplayer.display(this.subChannel, "subChannel");
        jceDisplayer.display(this.builderNum, "builderNum");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.name, true);
        jceDisplayer.displaySimple(this.versionName, true);
        jceDisplayer.displaySimple(this.versionCode, true);
        jceDisplayer.displaySimple(this.channel, true);
        jceDisplayer.displaySimple(this.subChannel, true);
        jceDisplayer.displaySimple(this.builderNum, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.SdkInfo sdkInfo = (com.tencent.tmassistantbase.jce.SdkInfo) obj;
        return com.qq.taf.jce.JceUtil.equals(this.name, sdkInfo.name) && com.qq.taf.jce.JceUtil.equals(this.versionName, sdkInfo.versionName) && com.qq.taf.jce.JceUtil.equals(this.versionCode, sdkInfo.versionCode) && com.qq.taf.jce.JceUtil.equals(this.channel, sdkInfo.channel) && com.qq.taf.jce.JceUtil.equals(this.subChannel, sdkInfo.subChannel) && com.qq.taf.jce.JceUtil.equals(this.builderNum, sdkInfo.builderNum);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmdownloader.internal.protocol.SDKSys.SdkInfo";
    }

    public java.lang.String getBuilderNum() {
        return this.builderNum;
    }

    public java.lang.String getChannel() {
        return this.channel;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getSubChannel() {
        return this.subChannel;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public java.lang.String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.versionName = jceInputStream.readString(1, false);
        this.versionCode = jceInputStream.read(this.versionCode, 2, false);
        this.channel = jceInputStream.readString(3, false);
        this.subChannel = jceInputStream.readString(4, false);
        this.builderNum = jceInputStream.readString(5, false);
    }

    public void setBuilderNum(java.lang.String str) {
        this.builderNum = str;
    }

    public void setChannel(java.lang.String str) {
        this.channel = str;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setSubChannel(java.lang.String str) {
        this.subChannel = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(java.lang.String str) {
        this.versionName = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        java.lang.String str2 = this.versionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.versionCode, 2);
        java.lang.String str3 = this.channel;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        java.lang.String str4 = this.subChannel;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        java.lang.String str5 = this.builderNum;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }
}
