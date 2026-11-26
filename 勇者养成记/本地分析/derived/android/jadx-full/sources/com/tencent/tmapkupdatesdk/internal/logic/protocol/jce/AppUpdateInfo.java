package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AppUpdateInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    public java.util.ArrayList apkDownUrl;
    public long apkId;
    public java.lang.String apkMd5;
    public java.lang.String apkUrl;
    public long appId;
    public java.lang.String appName;
    public java.lang.String cutEocdMd5;
    public java.lang.String diffApkMd5;
    public java.lang.String diffApkUrl;
    public long diffFileSize;
    public long downCount;
    public long fileSize;
    public int flag;
    public int grayVersionCode;
    public com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo iconUrl;
    public byte isAdded;
    public java.lang.String localFileListMd5;
    public java.lang.String localManifestMd5;
    public int localVersionCode;
    public java.lang.String localVersionName;
    public java.lang.String newFeature;
    public byte overwriteChannelid;
    public java.lang.String packageName;
    public short patchAlgorithm;
    public com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo rating;
    public java.lang.String signatureMd5;
    public int versionCode;
    public java.lang.String versionName;
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo.class.desiredAssertionStatus();
    static com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo cache_iconUrl = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo();
    static com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo cache_rating = new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo();
    static java.util.ArrayList cache_apkDownUrl = new java.util.ArrayList();

    static {
        cache_apkDownUrl.add(new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl());
    }

    public AppUpdateInfo() {
        this.packageName = "";
        this.appName = "";
        this.signatureMd5 = "";
        this.versionCode = 0;
        this.iconUrl = null;
        this.newFeature = "";
        this.rating = null;
        this.apkMd5 = "";
        this.apkUrl = "";
        this.fileSize = 0L;
        this.diffApkMd5 = "";
        this.diffApkUrl = "";
        this.diffFileSize = 0L;
        this.versionName = "";
        this.appId = 0L;
        this.downCount = 0L;
        this.flag = 0;
        this.apkId = 0L;
        this.apkDownUrl = null;
        this.isAdded = (byte) 0;
        this.grayVersionCode = 0;
        this.patchAlgorithm = (short) 0;
        this.localVersionName = "";
        this.localVersionCode = 0;
        this.localFileListMd5 = "";
        this.localManifestMd5 = "";
        this.overwriteChannelid = (byte) 0;
        this.cutEocdMd5 = "";
    }

    public AppUpdateInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo picInfo, java.lang.String str4, com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo ratingInfo, java.lang.String str5, java.lang.String str6, long j, java.lang.String str7, java.lang.String str8, long j2, java.lang.String str9, long j3, long j4, int i2, long j5, java.util.ArrayList arrayList, byte b, int i3, short s, java.lang.String str10, int i4, java.lang.String str11, java.lang.String str12, byte b2, java.lang.String str13) {
        this.packageName = "";
        this.appName = "";
        this.signatureMd5 = "";
        this.versionCode = 0;
        this.iconUrl = null;
        this.newFeature = "";
        this.rating = null;
        this.apkMd5 = "";
        this.apkUrl = "";
        this.fileSize = 0L;
        this.diffApkMd5 = "";
        this.diffApkUrl = "";
        this.diffFileSize = 0L;
        this.versionName = "";
        this.appId = 0L;
        this.downCount = 0L;
        this.flag = 0;
        this.apkId = 0L;
        this.apkDownUrl = null;
        this.isAdded = (byte) 0;
        this.grayVersionCode = 0;
        this.patchAlgorithm = (short) 0;
        this.localVersionName = "";
        this.localVersionCode = 0;
        this.localFileListMd5 = "";
        this.localManifestMd5 = "";
        this.overwriteChannelid = (byte) 0;
        this.cutEocdMd5 = "";
        this.packageName = str;
        this.appName = str2;
        this.signatureMd5 = str3;
        this.versionCode = i;
        this.iconUrl = picInfo;
        this.newFeature = str4;
        this.rating = ratingInfo;
        this.apkMd5 = str5;
        this.apkUrl = str6;
        this.fileSize = j;
        this.diffApkMd5 = str7;
        this.diffApkUrl = str8;
        this.diffFileSize = j2;
        this.versionName = str9;
        this.appId = j3;
        this.downCount = j4;
        this.flag = i2;
        this.apkId = j5;
        this.apkDownUrl = arrayList;
        this.isAdded = b;
        this.grayVersionCode = i3;
        this.patchAlgorithm = s;
        this.localVersionName = str10;
        this.localVersionCode = i4;
        this.localFileListMd5 = str11;
        this.localManifestMd5 = str12;
        this.overwriteChannelid = b2;
        this.cutEocdMd5 = str13;
    }

    public java.lang.String className() {
        return "jce.AppUpdateInfo";
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
        jceDisplayer.display(this.appName, "appName");
        jceDisplayer.display(this.signatureMd5, "signatureMd5");
        jceDisplayer.display(this.versionCode, "versionCode");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.iconUrl, "iconUrl");
        jceDisplayer.display(this.newFeature, "newFeature");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.rating, "rating");
        jceDisplayer.display(this.apkMd5, "apkMd5");
        jceDisplayer.display(this.apkUrl, "apkUrl");
        jceDisplayer.display(this.fileSize, "fileSize");
        jceDisplayer.display(this.diffApkMd5, "diffApkMd5");
        jceDisplayer.display(this.diffApkUrl, "diffApkUrl");
        jceDisplayer.display(this.diffFileSize, "diffFileSize");
        jceDisplayer.display(this.versionName, "versionName");
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.downCount, "downCount");
        jceDisplayer.display(this.flag, "flag");
        jceDisplayer.display(this.apkId, "apkId");
        jceDisplayer.display((java.util.Collection) this.apkDownUrl, "apkDownUrl");
        jceDisplayer.display(this.isAdded, "isAdded");
        jceDisplayer.display(this.grayVersionCode, "grayVersionCode");
        jceDisplayer.display(this.patchAlgorithm, "patchAlgorithm");
        jceDisplayer.display(this.localVersionName, "localVersionName");
        jceDisplayer.display(this.localVersionCode, "localVersionCode");
        jceDisplayer.display(this.localFileListMd5, "localFileListMd5");
        jceDisplayer.display(this.localManifestMd5, "localManifestMd5");
        jceDisplayer.display(this.overwriteChannelid, "overwriteChannelid");
        jceDisplayer.display(this.cutEocdMd5, "cutEocdMd5");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.packageName, true);
        jceDisplayer.displaySimple(this.appName, true);
        jceDisplayer.displaySimple(this.signatureMd5, true);
        jceDisplayer.displaySimple(this.versionCode, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.iconUrl, true);
        jceDisplayer.displaySimple(this.newFeature, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.rating, true);
        jceDisplayer.displaySimple(this.apkMd5, true);
        jceDisplayer.displaySimple(this.apkUrl, true);
        jceDisplayer.displaySimple(this.fileSize, true);
        jceDisplayer.displaySimple(this.diffApkMd5, true);
        jceDisplayer.displaySimple(this.diffApkUrl, true);
        jceDisplayer.displaySimple(this.diffFileSize, true);
        jceDisplayer.displaySimple(this.versionName, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.downCount, true);
        jceDisplayer.displaySimple(this.flag, true);
        jceDisplayer.displaySimple(this.apkId, true);
        jceDisplayer.displaySimple((java.util.Collection) this.apkDownUrl, true);
        jceDisplayer.displaySimple(this.isAdded, true);
        jceDisplayer.displaySimple(this.grayVersionCode, true);
        jceDisplayer.displaySimple(this.patchAlgorithm, true);
        jceDisplayer.displaySimple(this.localVersionName, true);
        jceDisplayer.displaySimple(this.localVersionCode, true);
        jceDisplayer.displaySimple(this.localFileListMd5, true);
        jceDisplayer.displaySimple(this.localManifestMd5, true);
        jceDisplayer.displaySimple(this.overwriteChannelid, true);
        jceDisplayer.displaySimple(this.cutEocdMd5, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo appUpdateInfo = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo) obj;
        return com.qq.taf.jce.JceUtil.equals(this.packageName, appUpdateInfo.packageName) && com.qq.taf.jce.JceUtil.equals(this.appName, appUpdateInfo.appName) && com.qq.taf.jce.JceUtil.equals(this.signatureMd5, appUpdateInfo.signatureMd5) && com.qq.taf.jce.JceUtil.equals(this.versionCode, appUpdateInfo.versionCode) && com.qq.taf.jce.JceUtil.equals(this.iconUrl, appUpdateInfo.iconUrl) && com.qq.taf.jce.JceUtil.equals(this.newFeature, appUpdateInfo.newFeature) && com.qq.taf.jce.JceUtil.equals(this.rating, appUpdateInfo.rating) && com.qq.taf.jce.JceUtil.equals(this.apkMd5, appUpdateInfo.apkMd5) && com.qq.taf.jce.JceUtil.equals(this.apkUrl, appUpdateInfo.apkUrl) && com.qq.taf.jce.JceUtil.equals(this.fileSize, appUpdateInfo.fileSize) && com.qq.taf.jce.JceUtil.equals(this.diffApkMd5, appUpdateInfo.diffApkMd5) && com.qq.taf.jce.JceUtil.equals(this.diffApkUrl, appUpdateInfo.diffApkUrl) && com.qq.taf.jce.JceUtil.equals(this.diffFileSize, appUpdateInfo.diffFileSize) && com.qq.taf.jce.JceUtil.equals(this.versionName, appUpdateInfo.versionName) && com.qq.taf.jce.JceUtil.equals(this.appId, appUpdateInfo.appId) && com.qq.taf.jce.JceUtil.equals(this.downCount, appUpdateInfo.downCount) && com.qq.taf.jce.JceUtil.equals(this.flag, appUpdateInfo.flag) && com.qq.taf.jce.JceUtil.equals(this.apkId, appUpdateInfo.apkId) && com.qq.taf.jce.JceUtil.equals(this.apkDownUrl, appUpdateInfo.apkDownUrl) && com.qq.taf.jce.JceUtil.equals(this.isAdded, appUpdateInfo.isAdded) && com.qq.taf.jce.JceUtil.equals(this.grayVersionCode, appUpdateInfo.grayVersionCode) && com.qq.taf.jce.JceUtil.equals(this.patchAlgorithm, appUpdateInfo.patchAlgorithm) && com.qq.taf.jce.JceUtil.equals(this.localVersionName, appUpdateInfo.localVersionName) && com.qq.taf.jce.JceUtil.equals(this.localVersionCode, appUpdateInfo.localVersionCode) && com.qq.taf.jce.JceUtil.equals(this.localFileListMd5, appUpdateInfo.localFileListMd5) && com.qq.taf.jce.JceUtil.equals(this.localManifestMd5, appUpdateInfo.localManifestMd5) && com.qq.taf.jce.JceUtil.equals(this.overwriteChannelid, appUpdateInfo.overwriteChannelid) && com.qq.taf.jce.JceUtil.equals(this.cutEocdMd5, appUpdateInfo.cutEocdMd5);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo";
    }

    public java.util.ArrayList getApkDownUrl() {
        return this.apkDownUrl;
    }

    public long getApkId() {
        return this.apkId;
    }

    public java.lang.String getApkMd5() {
        return this.apkMd5;
    }

    public java.lang.String getApkUrl() {
        return this.apkUrl;
    }

    public long getAppId() {
        return this.appId;
    }

    public java.lang.String getAppName() {
        return this.appName;
    }

    public java.lang.String getCutEocdMd5() {
        return this.cutEocdMd5;
    }

    public java.lang.String getDiffApkMd5() {
        return this.diffApkMd5;
    }

    public java.lang.String getDiffApkUrl() {
        return this.diffApkUrl;
    }

    public long getDiffFileSize() {
        return this.diffFileSize;
    }

    public long getDownCount() {
        return this.downCount;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getGrayVersionCode() {
        return this.grayVersionCode;
    }

    public com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo getIconUrl() {
        return this.iconUrl;
    }

    public byte getIsAdded() {
        return this.isAdded;
    }

    public java.lang.String getLocalFileListMd5() {
        return this.localFileListMd5;
    }

    public java.lang.String getLocalManifestMd5() {
        return this.localManifestMd5;
    }

    public int getLocalVersionCode() {
        return this.localVersionCode;
    }

    public java.lang.String getLocalVersionName() {
        return this.localVersionName;
    }

    public java.lang.String getNewFeature() {
        return this.newFeature;
    }

    public byte getOverwriteChannelid() {
        return this.overwriteChannelid;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public short getPatchAlgorithm() {
        return this.patchAlgorithm;
    }

    public com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo getRating() {
        return this.rating;
    }

    public java.lang.String getSignatureMd5() {
        return this.signatureMd5;
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
        this.appName = jceInputStream.readString(1, true);
        this.signatureMd5 = jceInputStream.readString(2, true);
        this.versionCode = jceInputStream.read(this.versionCode, 3, true);
        this.iconUrl = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo) jceInputStream.read((com.qq.taf.jce.JceStruct) cache_iconUrl, 4, true);
        this.newFeature = jceInputStream.readString(5, true);
        this.rating = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo) jceInputStream.read((com.qq.taf.jce.JceStruct) cache_rating, 6, true);
        this.apkMd5 = jceInputStream.readString(7, true);
        this.apkUrl = jceInputStream.readString(8, true);
        this.fileSize = jceInputStream.read(this.fileSize, 9, true);
        this.diffApkMd5 = jceInputStream.readString(10, false);
        this.diffApkUrl = jceInputStream.readString(11, false);
        this.diffFileSize = jceInputStream.read(this.diffFileSize, 12, false);
        this.versionName = jceInputStream.readString(13, false);
        this.appId = jceInputStream.read(this.appId, 14, false);
        this.downCount = jceInputStream.read(this.downCount, 15, false);
        this.flag = jceInputStream.read(this.flag, 16, false);
        this.apkId = jceInputStream.read(this.apkId, 18, false);
        this.apkDownUrl = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_apkDownUrl, 19, false);
        this.isAdded = jceInputStream.read(this.isAdded, 21, false);
        this.grayVersionCode = jceInputStream.read(this.grayVersionCode, 22, false);
        this.patchAlgorithm = jceInputStream.read(this.patchAlgorithm, 23, false);
        this.localVersionName = jceInputStream.readString(24, false);
        this.localVersionCode = jceInputStream.read(this.localVersionCode, 25, false);
        this.localFileListMd5 = jceInputStream.readString(26, false);
        this.localManifestMd5 = jceInputStream.readString(27, false);
        this.overwriteChannelid = jceInputStream.read(this.overwriteChannelid, 28, false);
        this.cutEocdMd5 = jceInputStream.readString(29, false);
    }

    public void setApkDownUrl(java.util.ArrayList arrayList) {
        this.apkDownUrl = arrayList;
    }

    public void setApkId(long j) {
        this.apkId = j;
    }

    public void setApkMd5(java.lang.String str) {
        this.apkMd5 = str;
    }

    public void setApkUrl(java.lang.String str) {
        this.apkUrl = str;
    }

    public void setAppId(long j) {
        this.appId = j;
    }

    public void setAppName(java.lang.String str) {
        this.appName = str;
    }

    public void setCutEocdMd5(java.lang.String str) {
        this.cutEocdMd5 = str;
    }

    public void setDiffApkMd5(java.lang.String str) {
        this.diffApkMd5 = str;
    }

    public void setDiffApkUrl(java.lang.String str) {
        this.diffApkUrl = str;
    }

    public void setDiffFileSize(long j) {
        this.diffFileSize = j;
    }

    public void setDownCount(long j) {
        this.downCount = j;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setGrayVersionCode(int i) {
        this.grayVersionCode = i;
    }

    public void setIconUrl(com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.PicInfo picInfo) {
        this.iconUrl = picInfo;
    }

    public void setIsAdded(byte b) {
        this.isAdded = b;
    }

    public void setLocalFileListMd5(java.lang.String str) {
        this.localFileListMd5 = str;
    }

    public void setLocalManifestMd5(java.lang.String str) {
        this.localManifestMd5 = str;
    }

    public void setLocalVersionCode(int i) {
        this.localVersionCode = i;
    }

    public void setLocalVersionName(java.lang.String str) {
        this.localVersionName = str;
    }

    public void setNewFeature(java.lang.String str) {
        this.newFeature = str;
    }

    public void setOverwriteChannelid(byte b) {
        this.overwriteChannelid = b;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setPatchAlgorithm(short s) {
        this.patchAlgorithm = s;
    }

    public void setRating(com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.RatingInfo ratingInfo) {
        this.rating = ratingInfo;
    }

    public void setSignatureMd5(java.lang.String str) {
        this.signatureMd5 = str;
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
        jceOutputStream.write(this.appName, 1);
        jceOutputStream.write(this.signatureMd5, 2);
        jceOutputStream.write(this.versionCode, 3);
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.iconUrl, 4);
        jceOutputStream.write(this.newFeature, 5);
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.rating, 6);
        jceOutputStream.write(this.apkMd5, 7);
        jceOutputStream.write(this.apkUrl, 8);
        jceOutputStream.write(this.fileSize, 9);
        java.lang.String str = this.diffApkMd5;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        java.lang.String str2 = this.diffApkUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.diffFileSize, 12);
        java.lang.String str3 = this.versionName;
        if (str3 != null) {
            jceOutputStream.write(str3, 13);
        }
        jceOutputStream.write(this.appId, 14);
        jceOutputStream.write(this.downCount, 15);
        jceOutputStream.write(this.flag, 16);
        jceOutputStream.write(this.apkId, 18);
        java.util.ArrayList arrayList = this.apkDownUrl;
        if (arrayList != null) {
            jceOutputStream.write((java.util.Collection) arrayList, 19);
        }
        jceOutputStream.write(this.isAdded, 21);
        jceOutputStream.write(this.grayVersionCode, 22);
        jceOutputStream.write(this.patchAlgorithm, 23);
        java.lang.String str4 = this.localVersionName;
        if (str4 != null) {
            jceOutputStream.write(str4, 24);
        }
        jceOutputStream.write(this.localVersionCode, 25);
        java.lang.String str5 = this.localFileListMd5;
        if (str5 != null) {
            jceOutputStream.write(str5, 26);
        }
        java.lang.String str6 = this.localManifestMd5;
        if (str6 != null) {
            jceOutputStream.write(str6, 27);
        }
        jceOutputStream.write(this.overwriteChannelid, 28);
        java.lang.String str7 = this.cutEocdMd5;
        if (str7 != null) {
            jceOutputStream.write(str7, 29);
        }
    }
}
