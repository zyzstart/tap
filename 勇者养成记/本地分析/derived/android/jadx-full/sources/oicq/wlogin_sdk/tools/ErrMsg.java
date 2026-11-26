package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ErrMsg implements android.os.Parcelable, java.lang.Cloneable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: oicq.wlogin_sdk.tools.ErrMsg.1
        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.tools.ErrMsg createFromParcel(android.os.Parcel parcel) {
            return new oicq.wlogin_sdk.tools.ErrMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.tools.ErrMsg[] newArray(int i) {
            return new oicq.wlogin_sdk.tools.ErrMsg[i];
        }
    };
    private java.lang.String message;
    private java.lang.String otherinfo;
    private java.lang.String title;
    private int type;

    public ErrMsg() {
        this.type = 0;
        this.title = oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_0);
        this.message = oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_1);
        this.otherinfo = "";
    }

    public ErrMsg(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.type = i;
        this.title = str;
        this.message = str2;
        this.otherinfo = str3;
    }

    private ErrMsg(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    public java.lang.Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public java.lang.String getOtherinfo() {
        return this.otherinfo;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.otherinfo = parcel.readString();
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public void setOtherinfo(java.lang.String str) {
        this.otherinfo = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        int i = this.type;
        sb.append(i < 0 ? java.lang.Integer.valueOf(i) : java.lang.Integer.toString(i));
        sb.append(")[");
        return sb.toString() + this.title + "]" + this.message + "[" + this.otherinfo + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.otherinfo);
    }
}
