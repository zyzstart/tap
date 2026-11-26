package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AppInfoForUpdate extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate.class.desiredAssertionStatus();
    public byte actionFlag;
    public long appId;
    public byte appType;
    public java.lang.String cutEocdMd5;
    public int grayVersionCode;
    public java.lang.String manifestMd5;
    public java.lang.String packageName;
    public java.lang.String signatureMd5;
    public int targetGrayVersionCode;
    public int targetVersionCode;
    public int versionCode;
    public java.lang.String versionName;

    public AppInfoForUpdate() {
        this.packageName = "";
        this.signatureMd5 = "";
        this.versionCode = 0;
        this.manifestMd5 = "";
        this.appId = 0L;
        this.appType = (byte) 1;
        this.versionName = "";
        this.actionFlag = (byte) 0;
        this.grayVersionCode = 0;
        this.targetVersionCode = 0;
        this.targetGrayVersionCode = 0;
        this.cutEocdMd5 = "";
    }

    public AppInfoForUpdate(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, long j, byte b, java.lang.String str4, byte b2, int i2, int i3, int i4, java.lang.String str5) {
        this.packageName = "";
        this.signatureMd5 = "";
        this.versionCode = 0;
        this.manifestMd5 = "";
        this.appId = 0L;
        this.appType = (byte) 1;
        this.versionName = "";
        this.actionFlag = (byte) 0;
        this.grayVersionCode = 0;
        this.targetVersionCode = 0;
        this.targetGrayVersionCode = 0;
        this.cutEocdMd5 = "";
        this.packageName = str;
        this.signatureMd5 = str2;
        this.versionCode = i;
        this.manifestMd5 = str3;
        this.appId = j;
        this.appType = b;
        this.versionName = str4;
        this.actionFlag = b2;
        this.grayVersionCode = i2;
        this.targetVersionCode = i3;
        this.targetGrayVersionCode = i4;
        this.cutEocdMd5 = str5;
    }

    public java.lang.String className() {
        return "jce.AppInfoForUpdate";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.packageName, "packageName");
        jceDisplayer.display(this.signatureMd5, "signatureMd5");
        jceDisplayer.display(this.versionCode, "versionCode");
        jceDisplayer.display(this.manifestMd5, "manifestMd5");
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.appType, "appType");
        jceDisplayer.display(this.versionName, "versionName");
        jceDisplayer.display(this.actionFlag, "actionFlag");
        jceDisplayer.display(this.grayVersionCode, "grayVersionCode");
        jceDisplayer.display(this.targetVersionCode, "targetVersionCode");
        jceDisplayer.display(this.targetGrayVersionCode, "targetGrayVersionCode");
        jceDisplayer.display(this.cutEocdMd5, "cutEocdMd5");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.packageName, true);
        jceDisplayer.displaySimple(this.signatureMd5, true);
        jceDisplayer.displaySimple(this.versionCode, true);
        jceDisplayer.displaySimple(this.manifestMd5, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.appType, true);
        jceDisplayer.displaySimple(this.versionName, true);
        jceDisplayer.displaySimple(this.actionFlag, true);
        jceDisplayer.displaySimple(this.grayVersionCode, true);
        jceDisplayer.displaySimple(this.targetVersionCode, true);
        jceDisplayer.displaySimple(this.targetGrayVersionCode, true);
        jceDisplayer.displaySimple(this.cutEocdMd5, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate appInfoForUpdate = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate) obj;
        return com.qq.taf.jce.JceUtil.equals(this.packageName, appInfoForUpdate.packageName) && com.qq.taf.jce.JceUtil.equals(this.signatureMd5, appInfoForUpdate.signatureMd5) && com.qq.taf.jce.JceUtil.equals(this.versionCode, appInfoForUpdate.versionCode) && com.qq.taf.jce.JceUtil.equals(this.manifestMd5, appInfoForUpdate.manifestMd5) && com.qq.taf.jce.JceUtil.equals(this.appId, appInfoForUpdate.appId) && com.qq.taf.jce.JceUtil.equals(this.appType, appInfoForUpdate.appType) && com.qq.taf.jce.JceUtil.equals(this.versionName, appInfoForUpdate.versionName) && com.qq.taf.jce.JceUtil.equals(this.actionFlag, appInfoForUpdate.actionFlag) && com.qq.taf.jce.JceUtil.equals(this.grayVersionCode, appInfoForUpdate.grayVersionCode) && com.qq.taf.jce.JceUtil.equals(this.targetVersionCode, appInfoForUpdate.targetVersionCode) && com.qq.taf.jce.JceUtil.equals(this.targetGrayVersionCode, appInfoForUpdate.targetGrayVersionCode) && com.qq.taf.jce.JceUtil.equals(this.cutEocdMd5, appInfoForUpdate.cutEocdMd5);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate";
    }

    public byte getActionFlag() {
        return this.actionFlag;
    }

    public long getAppId() {
        return this.appId;
    }

    public byte getAppType() {
        return this.appType;
    }

    public java.lang.String getCutEocdMd5() {
        return this.cutEocdMd5;
    }

    public int getGrayVersionCode() {
        return this.grayVersionCode;
    }

    public java.lang.String getManifestMd5() {
        return this.manifestMd5;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getSignatureMd5() {
        return this.signatureMd5;
    }

    public int getTargetGrayVersionCode() {
        return this.targetGrayVersionCode;
    }

    public int getTargetVersionCode() {
        return this.targetVersionCode;
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
        this.packageName = jceInputStream.readString(0, true);
        this.signatureMd5 = jceInputStream.readString(1, true);
        this.versionCode = jceInputStream.read(this.versionCode, 2, true);
        this.manifestMd5 = jceInputStream.readString(3, false);
        this.appId = jceInputStream.read(this.appId, 4, false);
        this.appType = jceInputStream.read(this.appType, 5, false);
        this.versionName = jceInputStream.readString(6, false);
        this.actionFlag = jceInputStream.read(this.actionFlag, 7, false);
        this.grayVersionCode = jceInputStream.read(this.grayVersionCode, 8, false);
        this.targetVersionCode = jceInputStream.read(this.targetVersionCode, 9, false);
        this.targetGrayVersionCode = jceInputStream.read(this.targetGrayVersionCode, 10, false);
        this.cutEocdMd5 = jceInputStream.readString(11, false);
    }

    public void setActionFlag(byte b) {
        this.actionFlag = b;
    }

    public void setAppId(long j) {
        this.appId = j;
    }

    public void setAppType(byte b) {
        this.appType = b;
    }

    public void setCutEocdMd5(java.lang.String str) {
        this.cutEocdMd5 = str;
    }

    public void setGrayVersionCode(int i) {
        this.grayVersionCode = i;
    }

    public void setManifestMd5(java.lang.String str) {
        this.manifestMd5 = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setSignatureMd5(java.lang.String str) {
        this.signatureMd5 = str;
    }

    public void setTargetGrayVersionCode(int i) {
        this.targetGrayVersionCode = i;
    }

    public void setTargetVersionCode(int i) {
        this.targetVersionCode = i;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(java.lang.String str) {
        this.versionName = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.packageName, 0);
        jceOutputStream.write(this.signatureMd5, 1);
        jceOutputStream.write(this.versionCode, 2);
        java.lang.String str = this.manifestMd5;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.appId, 4);
        jceOutputStream.write(this.appType, 5);
        java.lang.String str2 = this.versionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.actionFlag, 7);
        jceOutputStream.write(this.grayVersionCode, 8);
        jceOutputStream.write(this.targetVersionCode, 9);
        jceOutputStream.write(this.targetGrayVersionCode, 10);
        java.lang.String str3 = this.cutEocdMd5;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
    }
}
