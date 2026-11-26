package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantCallYYBTaskInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new com.tencent.tmassistantsdk.a();
    public java.lang.String mContentType;
    public long mReceiveDataLen;
    public java.lang.String mSavePath;
    public int mState;
    public long mTotalDataLen;
    public java.lang.String mUrl;

    public TMAssistantCallYYBTaskInfo(java.lang.String str, java.lang.String str2, int i, long j, long j2, java.lang.String str3) {
        this.mUrl = str;
        this.mSavePath = str2;
        this.mState = i;
        this.mReceiveDataLen = j;
        this.mTotalDataLen = j2;
        this.mContentType = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        java.lang.String str = this.mUrl;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        java.lang.String str2 = this.mSavePath;
        if (str2 == null) {
            str2 = "";
        }
        parcel.writeString(str2);
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mReceiveDataLen);
        parcel.writeLong(this.mTotalDataLen);
        parcel.writeString(this.mContentType);
    }
}
