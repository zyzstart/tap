package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements android.os.Parcelable.Creator {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo createFromParcel(android.os.Parcel parcel) {
        return new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo[] newArray(int i) {
        return new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo[i];
    }
}
