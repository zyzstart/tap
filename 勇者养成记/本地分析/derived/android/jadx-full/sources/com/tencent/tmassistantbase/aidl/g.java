package com.tencent.tmassistantbase.aidl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g implements android.os.Parcelable.Creator {
    g() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo createFromParcel(android.os.Parcel parcel) {
        return new com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo[] newArray(int i) {
        return new com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo[i];
    }
}
