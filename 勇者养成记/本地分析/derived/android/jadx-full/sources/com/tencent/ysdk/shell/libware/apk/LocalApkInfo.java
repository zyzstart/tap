package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LocalApkInfo implements android.os.Parcelable {
    public static final int APK_STATE_INSTALL = 2;
    public static final int APK_STATE_NORMAL = 1;
    public static final int APK_STATE_SILENT_INSTALL = 3;
    public static final byte APP_INSTALL_TYPE_NO_SYSTEM = 1;
    public static final byte APP_INSTALL_TYPE_SYSTEM = 2;
    public static final android.os.Parcelable.Creator<com.tencent.ysdk.shell.libware.apk.LocalApkInfo> CREATOR = new android.os.Parcelable.Creator<com.tencent.ysdk.shell.libware.apk.LocalApkInfo>() { // from class: com.tencent.ysdk.shell.libware.apk.LocalApkInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.tencent.ysdk.shell.libware.apk.LocalApkInfo createFromParcel(android.os.Parcel parcel) {
            com.tencent.ysdk.shell.libware.apk.LocalApkInfo localApkInfo = new com.tencent.ysdk.shell.libware.apk.LocalApkInfo();
            localApkInfo.mPackageName = parcel.readString();
            localApkInfo.mVersionName = parcel.readString();
            localApkInfo.mAppName = parcel.readString();
            localApkInfo.mSortKey = parcel.readString();
            localApkInfo.mAppIconRes = parcel.readInt();
            localApkInfo.mVersionCode = parcel.readInt();
            localApkInfo.launchCount = parcel.readInt();
            localApkInfo.flags = parcel.readInt();
            localApkInfo.occupySize = parcel.readLong();
            localApkInfo.mInstallDate = parcel.readLong();
            localApkInfo.signature = parcel.readString();
            localApkInfo.manifestMd5 = parcel.readString();
            localApkInfo.mLocalFilePath = parcel.readString();
            localApkInfo.mLastLaunchTime = parcel.readLong();
            localApkInfo.mFakeLastLaunchTime = parcel.readLong();
            localApkInfo.mDataUsage = parcel.readLong();
            localApkInfo.mBatteryUsage = parcel.readLong();
            localApkInfo.mInstalleLocation = parcel.readByte();
            localApkInfo.mUid = parcel.readInt();
            localApkInfo.mIsSelect = parcel.readByte() != 0;
            localApkInfo.mIsSmartSlect = parcel.readByte() != 0;
            localApkInfo.mIsEnabled = parcel.readByte() != 0;
            return localApkInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.tencent.ysdk.shell.libware.apk.LocalApkInfo[] newArray(int i) {
            return null;
        }
    };
    public static final int ILLEGAL_LAUNCH_TIME = -1;
    public static final int INSTALL_LOCATION_PHONE = 1;
    public static final int INSTALL_LOCATION_SDCARD = 2;
    public int flags;
    public int launchCount;
    public int mAppIconRes;
    public java.lang.String mAppName;
    public long mInstallDate;
    public java.lang.String mLocalFilePath;
    public java.lang.String mPackageName;
    public java.lang.String mSortKey;
    public int mUid;
    public int mVersionCode;
    public java.lang.String mVersionName;
    public java.lang.String manifestMd5;
    public java.lang.String signature;
    public long occupySize = 0;
    public long mLastLaunchTime = -1;
    public long mFakeLastLaunchTime = -1;
    public long mDataUsage = 0;
    public long mBatteryUsage = 0;
    public byte mInstalleLocation = 1;
    public long mLastModified = 0;
    public boolean mInstall = false;
    public boolean mIsSelect = false;
    public int mApkState = 1;
    public int mGrayVersionCode = 0;
    public boolean mIsInternalDownload = true;
    public boolean mIsEmpty = false;
    public boolean mIsHistory = false;
    public boolean mIsSmartSlect = false;
    public boolean mIsUpdateApk = false;
    public boolean mIsEnabled = true;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.tencent.ysdk.shell.libware.apk.LocalApkInfo)) {
            return false;
        }
        return ((com.tencent.ysdk.shell.libware.apk.LocalApkInfo) obj).getLocalApkInfoKey().equals(getLocalApkInfoKey());
    }

    public byte getAppType() {
        return (this.flags & 1) != 0 ? (byte) 2 : (byte) 1;
    }

    public java.lang.String getLocalApkInfoKey() {
        if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(this.mPackageName)) {
            return this.mPackageName;
        }
        return this.mPackageName + this.mVersionCode + this.mGrayVersionCode;
    }

    public android.content.Intent getStartIntent(android.content.Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(this.mPackageName);
    }

    public int hashCode() {
        java.lang.String localApkInfoKey = getLocalApkInfoKey();
        if (localApkInfoKey == null) {
            return 0;
        }
        return localApkInfoKey.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mVersionName);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mSortKey);
        parcel.writeInt(this.mAppIconRes);
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.launchCount);
        parcel.writeInt(i);
        parcel.writeLong(this.occupySize);
        parcel.writeLong(this.mInstallDate);
        parcel.writeString(this.signature);
        parcel.writeString(this.manifestMd5);
        parcel.writeString(this.mLocalFilePath);
        parcel.writeLong(this.mLastLaunchTime);
        parcel.writeLong(this.mFakeLastLaunchTime);
        parcel.writeLong(this.mDataUsage);
        parcel.writeLong(this.mBatteryUsage);
        parcel.writeByte(this.mInstalleLocation);
        parcel.writeInt(this.mUid);
        parcel.writeByte(this.mIsSelect ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSmartSlect ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsEnabled ? (byte) 1 : (byte) 0);
    }
}
