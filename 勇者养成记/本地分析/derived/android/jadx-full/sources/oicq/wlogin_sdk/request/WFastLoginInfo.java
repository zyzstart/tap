package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WFastLoginInfo implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: oicq.wlogin_sdk.request.WFastLoginInfo.1
        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.WFastLoginInfo createFromParcel(android.os.Parcel parcel) {
            return new oicq.wlogin_sdk.request.WFastLoginInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.WFastLoginInfo[] newArray(int i) {
            return new oicq.wlogin_sdk.request.WFastLoginInfo[i];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _outA1;
    public java.lang.String adUrl;
    public java.lang.String iconUrl;
    public java.lang.String profileUrl;

    public WFastLoginInfo() {
        this._outA1 = new byte[0];
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        this._outA1 = new byte[0];
    }

    private WFastLoginInfo(android.os.Parcel parcel) {
        this._outA1 = new byte[0];
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        readFromParcel(parcel);
    }

    public WFastLoginInfo(byte[] bArr) {
        this._outA1 = new byte[0];
        this.iconUrl = "";
        this.adUrl = "";
        this.profileUrl = "";
        this._outA1 = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void get_clone(oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo) {
        if (wFastLoginInfo != null) {
            byte[] bArr = wFastLoginInfo._outA1;
            this._outA1 = bArr != null ? (byte[]) bArr.clone() : new byte[0];
            this.iconUrl = wFastLoginInfo.iconUrl;
            this.adUrl = wFastLoginInfo.adUrl;
            this.profileUrl = wFastLoginInfo.profileUrl;
        }
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this._outA1 = parcel.createByteArray();
        this.iconUrl = parcel.readString();
        this.adUrl = parcel.readString();
        this.profileUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByteArray(this._outA1);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.adUrl);
        parcel.writeString(this.profileUrl);
    }
}
