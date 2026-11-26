package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c implements android.os.Parcelable.Creator {
    c() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public oicq.wlogin_sdk.devicelock.DevlockInfo createFromParcel(android.os.Parcel parcel) {
        return new oicq.wlogin_sdk.devicelock.DevlockInfo(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public oicq.wlogin_sdk.devicelock.DevlockInfo[] newArray(int i) {
        return new oicq.wlogin_sdk.devicelock.DevlockInfo[i];
    }
}
