package com.tencent.tmselfupdatesdk.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements android.os.Parcelable.Creator {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo createFromParcel(android.os.Parcel parcel) {
        return new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo[] newArray(int i) {
        return new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo[i];
    }
}
