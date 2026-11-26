package com.tencent.tmselfupdatesdk.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMSelfUpdateUpdateInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new com.tencent.tmselfupdatesdk.model.a();
    public static final int STATUS_CHECKUPDATE_FAILURE = 1;
    public static final int STATUS_CHECKUPDATE_RESPONSE_IS_NULL = 2;
    public static final int STATUS_OK = 0;
    public static final int UpdateMethod_ByPatch = 2;
    public static final int UpdateMethod_NoUpdate = 0;
    public static final int UpdateMethod_Normal = 1;
    private long newApkSize;
    private java.lang.String newFeature;
    private byte overwriteChannelid;
    private long patchSize;
    private int status;
    private java.lang.String updateDownloadUrl;
    private int updateMethod;
    public int versioncode;
    public java.lang.String versionname;

    public TMSelfUpdateUpdateInfo(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, byte b, java.lang.String str3, int i3) {
        this.status = 0;
        this.status = i;
        this.updateMethod = i2;
        this.newApkSize = j;
        this.patchSize = j2;
        this.newFeature = str;
        this.updateDownloadUrl = str2;
        this.overwriteChannelid = b;
        this.versionname = str3;
        this.versioncode = i3;
    }

    protected TMSelfUpdateUpdateInfo(android.os.Parcel parcel) {
        this.status = 0;
        this.status = parcel.readInt();
        this.updateMethod = parcel.readInt();
        this.newApkSize = parcel.readLong();
        this.patchSize = parcel.readLong();
        this.newFeature = parcel.readString();
        this.updateDownloadUrl = parcel.readString();
        this.overwriteChannelid = parcel.readByte();
        this.versionname = parcel.readString();
        this.versioncode = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getNewApkSize() {
        return this.newApkSize;
    }

    public java.lang.String getNewFeature() {
        return this.newFeature;
    }

    public byte getOverwriteChannelid() {
        return this.overwriteChannelid;
    }

    public long getPatchSize() {
        return this.patchSize;
    }

    public int getStatus() {
        return this.status;
    }

    public java.lang.String getUpdateDownloadUrl() {
        return this.updateDownloadUrl;
    }

    public int getUpdateMethod() {
        return this.updateMethod;
    }

    public void setNewApkSize(long j) {
        this.newApkSize = j;
    }

    public void setNewFeature(java.lang.String str) {
        this.newFeature = str;
    }

    public void setOverwriteChannelid(byte b) {
        this.overwriteChannelid = b;
    }

    public void setPatchSize(long j) {
        this.patchSize = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUpdateDownloadUrl(java.lang.String str) {
        this.updateDownloadUrl = str;
    }

    public void setUpdateMethod(int i) {
        this.updateMethod = i;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("status :" + this.status + '\n');
        sb.append("updateMethod :" + this.updateMethod + '\n');
        sb.append("newApkSize :" + this.newApkSize + '\n');
        sb.append("patchSize :" + this.patchSize + '\n');
        sb.append("newFeature :" + this.newFeature + '\n');
        sb.append("updateDownloadUrl :" + this.updateDownloadUrl + '\n');
        sb.append("overwriteChannelid :" + ((int) this.overwriteChannelid) + '\n');
        sb.append("versionname :" + this.versionname + '\n');
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("versioncode :");
        sb2.append(this.versioncode);
        sb.append(sb2.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.updateMethod);
        parcel.writeLong(this.newApkSize);
        parcel.writeLong(this.patchSize);
        parcel.writeString(this.newFeature);
        parcel.writeString(this.updateDownloadUrl);
        parcel.writeByte(this.overwriteChannelid);
        parcel.writeString(this.versionname);
        parcel.writeInt(this.versioncode);
    }
}
