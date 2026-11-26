package oicq.wlogin_sdk.sharemem;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WloginLoginInfo implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator CREATOR = new oicq.wlogin_sdk.sharemem.a();
    public static int TYPE_LOACL = 1;
    public static int TYPE_REMOTE = 2;
    private static final long serialVersionUID = 5551948389726789420L;
    public java.lang.String mAccount;
    public long mAppid;
    public long mCreateTime;
    public java.lang.String mFaceUrl;
    public int mLoginBitmap;
    public int mType;
    public long mUin;

    private WloginLoginInfo(android.os.Parcel parcel) {
        this.mFaceUrl = "";
        readFromParcel(parcel);
    }

    /* synthetic */ WloginLoginInfo(android.os.Parcel parcel, oicq.wlogin_sdk.sharemem.a aVar) {
        this(parcel);
    }

    public WloginLoginInfo(java.lang.String str, long j, long j2, java.lang.String str2, long j3, int i, int i2) {
        this.mFaceUrl = "";
        this.mAccount = str;
        this.mUin = j;
        this.mAppid = j2;
        this.mFaceUrl = str2;
        this.mCreateTime = j3;
        this.mType = i;
        this.mLoginBitmap = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.mAccount = parcel.readString();
        this.mUin = parcel.readLong();
        this.mAppid = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mType = parcel.readInt();
        this.mLoginBitmap = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mAccount);
        parcel.writeLong(this.mUin);
        parcel.writeLong(this.mAppid);
        parcel.writeLong(this.mCreateTime);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mLoginBitmap);
    }
}
