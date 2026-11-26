package oicq.wlogin_sdk.sharemem;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements android.os.Parcelable.Creator {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public oicq.wlogin_sdk.sharemem.WloginLoginInfo createFromParcel(android.os.Parcel parcel) {
        return new oicq.wlogin_sdk.sharemem.WloginLoginInfo(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public oicq.wlogin_sdk.sharemem.WloginLoginInfo[] newArray(int i) {
        return new oicq.wlogin_sdk.sharemem.WloginLoginInfo[i];
    }
}
