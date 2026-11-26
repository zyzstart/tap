package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DevlockInfo implements android.os.Parcelable, java.lang.Cloneable {
    public static final android.os.Parcelable.Creator CREATOR = new oicq.wlogin_sdk.devicelock.c();
    public int AllowSet;
    public int AvailableMsgCount;
    public java.lang.String BakCountryCode;
    public java.lang.String BakMobile;
    public int BakMobileState;
    public java.lang.String CountryCode;
    public int DevSetup;
    public java.lang.String MbGuideInfo;
    public int MbGuideInfoType;
    public java.lang.String MbGuideMsg;
    public int MbGuideType;
    public int MbItemSmsCodeStatus;
    public java.lang.String Mobile;
    public java.lang.String ProtectIntro;
    public int TimeLimit;
    public byte[] TransferInfo;
    public java.lang.String UnionVerifyUrl;
    public java.lang.String VerifyReason;
    public java.lang.String WarningInfo;
    public int WarningInfoType;
    public java.lang.String WarningMsg;
    public java.lang.String WarningTitle;

    public DevlockInfo() {
    }

    private DevlockInfo(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    /* synthetic */ DevlockInfo(android.os.Parcel parcel, oicq.wlogin_sdk.devicelock.c cVar) {
        this(parcel);
    }

    public java.lang.Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.DevSetup = parcel.readInt();
        this.AllowSet = parcel.readInt();
        this.ProtectIntro = parcel.readString();
        this.WarningTitle = parcel.readString();
        this.WarningMsg = parcel.readString();
        this.WarningInfo = parcel.readString();
        this.WarningInfoType = parcel.readInt();
        this.CountryCode = parcel.readString();
        this.Mobile = parcel.readString();
        this.MbItemSmsCodeStatus = parcel.readInt();
        this.AvailableMsgCount = parcel.readInt();
        this.TimeLimit = parcel.readInt();
        this.MbGuideMsg = parcel.readString();
        this.MbGuideInfo = parcel.readString();
        this.MbGuideType = parcel.readInt();
        this.MbGuideInfoType = parcel.readInt();
        this.UnionVerifyUrl = parcel.readString();
        this.VerifyReason = parcel.readString();
        this.BakMobileState = parcel.readInt();
        this.BakCountryCode = parcel.readString();
        this.BakMobile = parcel.readString();
        int i = parcel.readInt();
        if (i > 0) {
            byte[] bArr = new byte[i];
            this.TransferInfo = bArr;
            parcel.readByteArray(bArr);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.DevSetup);
        parcel.writeInt(this.AllowSet);
        parcel.writeString(this.ProtectIntro);
        parcel.writeString(this.WarningTitle);
        parcel.writeString(this.WarningMsg);
        parcel.writeString(this.WarningInfo);
        parcel.writeInt(this.WarningInfoType);
        parcel.writeString(this.CountryCode);
        parcel.writeString(this.Mobile);
        parcel.writeInt(this.MbItemSmsCodeStatus);
        parcel.writeInt(this.AvailableMsgCount);
        parcel.writeInt(this.TimeLimit);
        parcel.writeString(this.MbGuideMsg);
        parcel.writeString(this.MbGuideInfo);
        parcel.writeInt(this.MbGuideType);
        parcel.writeInt(this.MbGuideInfoType);
        parcel.writeString(this.UnionVerifyUrl);
        parcel.writeString(this.VerifyReason);
        parcel.writeInt(this.BakMobileState);
        parcel.writeString(this.BakCountryCode);
        parcel.writeString(this.BakMobile);
        byte[] bArr = this.TransferInfo;
        if (bArr == null || bArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.TransferInfo);
        }
    }
}
