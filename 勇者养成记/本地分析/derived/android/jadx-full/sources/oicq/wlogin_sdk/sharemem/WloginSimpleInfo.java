package oicq.wlogin_sdk.sharemem;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WloginSimpleInfo implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: oicq.wlogin_sdk.sharemem.WloginSimpleInfo.1
        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.sharemem.WloginSimpleInfo createFromParcel(android.os.Parcel parcel) {
            return new oicq.wlogin_sdk.sharemem.WloginSimpleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.sharemem.WloginSimpleInfo[] newArray(int i) {
            return new oicq.wlogin_sdk.sharemem.WloginSimpleInfo[i];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _age;
    public byte[] _face;
    public byte[] _gender;
    public byte[] _img_format;
    public byte[] _img_type;
    public byte[] _img_url;
    public byte[] _nick;
    public long _uin;
    public byte[] mainDisplayName;

    public WloginSimpleInfo() {
        this._uin = 0L;
        this._face = new byte[0];
        this._age = new byte[0];
        this._gender = new byte[0];
        this._nick = new byte[0];
        this._img_type = new byte[0];
        this._img_format = new byte[0];
        this._img_url = new byte[0];
        this.mainDisplayName = new byte[0];
    }

    public WloginSimpleInfo(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        this._uin = j;
        this._face = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        this._age = bArr2 != null ? (byte[]) bArr2.clone() : new byte[0];
        this._gender = bArr3 != null ? (byte[]) bArr3.clone() : new byte[0];
        this._nick = bArr4 != null ? (byte[]) bArr4.clone() : new byte[0];
        this._img_type = bArr5 != null ? (byte[]) bArr5.clone() : new byte[0];
        this._img_format = bArr6 != null ? (byte[]) bArr6.clone() : new byte[0];
        this._img_url = bArr7 != null ? (byte[]) bArr7.clone() : new byte[0];
    }

    public WloginSimpleInfo(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][] bArr5) {
        byte[] bArr6;
        this._uin = j;
        this._face = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        this._age = bArr2 != null ? (byte[]) bArr2.clone() : new byte[0];
        this._gender = bArr3 != null ? (byte[]) bArr3.clone() : new byte[0];
        this._nick = bArr4 != null ? (byte[]) bArr4.clone() : new byte[0];
        if (bArr5 == null || bArr5.length != 3) {
            this._img_type = new byte[0];
            this._img_format = new byte[0];
            bArr6 = new byte[0];
        } else {
            this._img_type = (byte[]) bArr5[0].clone();
            this._img_format = (byte[]) bArr5[1].clone();
            bArr6 = (byte[]) bArr5[2].clone();
        }
        this._img_url = bArr6;
    }

    private WloginSimpleInfo(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public oicq.wlogin_sdk.sharemem.WloginSimpleInfo get_clone() {
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        wloginSimpleInfo._uin = this._uin;
        byte[] bArr = this._face;
        if (bArr != null) {
            wloginSimpleInfo._face = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this._age;
        if (bArr2 != null) {
            wloginSimpleInfo._age = (byte[]) bArr2.clone();
        }
        byte[] bArr3 = this._gender;
        if (bArr3 != null) {
            wloginSimpleInfo._gender = (byte[]) bArr3.clone();
        }
        byte[] bArr4 = this._nick;
        if (bArr4 != null) {
            wloginSimpleInfo._nick = (byte[]) bArr4.clone();
        }
        byte[] bArr5 = this._img_type;
        if (bArr5 != null) {
            wloginSimpleInfo._img_type = (byte[]) bArr5.clone();
        }
        byte[] bArr6 = this._img_format;
        if (bArr6 != null) {
            wloginSimpleInfo._img_format = (byte[]) bArr6.clone();
        }
        byte[] bArr7 = this._img_url;
        if (bArr7 != null) {
            wloginSimpleInfo._img_url = (byte[]) bArr7.clone();
        }
        byte[] bArr8 = this.mainDisplayName;
        if (bArr8 != null) {
            wloginSimpleInfo.mainDisplayName = (byte[]) bArr8.clone();
        }
        return wloginSimpleInfo;
    }

    public void get_clone(oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo) {
        this._uin = wloginSimpleInfo._uin;
        byte[] bArr = wloginSimpleInfo._face;
        this._face = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        byte[] bArr2 = wloginSimpleInfo._age;
        this._age = bArr2 != null ? (byte[]) bArr2.clone() : new byte[0];
        byte[] bArr3 = wloginSimpleInfo._gender;
        this._gender = bArr3 != null ? (byte[]) bArr3.clone() : new byte[0];
        byte[] bArr4 = wloginSimpleInfo._nick;
        this._nick = bArr4 != null ? (byte[]) bArr4.clone() : new byte[0];
        byte[] bArr5 = wloginSimpleInfo._img_type;
        this._img_type = bArr5 != null ? (byte[]) bArr5.clone() : new byte[0];
        byte[] bArr6 = wloginSimpleInfo._img_format;
        this._img_format = bArr6 != null ? (byte[]) bArr6.clone() : new byte[0];
        byte[] bArr7 = wloginSimpleInfo._img_url;
        this._img_url = bArr7 != null ? (byte[]) bArr7.clone() : new byte[0];
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this._uin = parcel.readLong();
        this._face = parcel.createByteArray();
        this._age = parcel.createByteArray();
        this._gender = parcel.createByteArray();
        this._nick = parcel.createByteArray();
        this._img_type = parcel.createByteArray();
        this._img_format = parcel.createByteArray();
        this._img_url = parcel.createByteArray();
        this.mainDisplayName = parcel.createByteArray();
    }

    public void setAge(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._age = (byte[]) bArr.clone();
    }

    public void setFace(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._face = (byte[]) bArr.clone();
    }

    public void setGender(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._gender = (byte[]) bArr.clone();
    }

    public void setImgFormat(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._img_format = (byte[]) bArr.clone();
    }

    public void setImgType(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._img_type = (byte[]) bArr.clone();
    }

    public void setImgUrl(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._img_url = (byte[]) bArr.clone();
    }

    public void setMainDisplayName(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this.mainDisplayName = (byte[]) bArr.clone();
    }

    public void setNick(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this._nick = (byte[]) bArr.clone();
    }

    public void setReserveUinInfo(byte[][] bArr) {
        if (bArr == null || bArr.length != 3 || bArr[0].length <= 0 || bArr[1].length <= 0 || bArr[2].length <= 0) {
            return;
        }
        this._img_type = (byte[]) bArr[0].clone();
        this._img_format = (byte[]) bArr[1].clone();
        this._img_url = (byte[]) bArr[2].clone();
    }

    public void setUin(long j) {
        this._uin = j;
    }

    public void set_info(oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo) {
        this._uin = wloginSimpleInfo._uin;
        byte[] bArr = wloginSimpleInfo._face;
        this._face = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        byte[] bArr2 = wloginSimpleInfo._age;
        this._age = bArr2 != null ? (byte[]) bArr2.clone() : new byte[0];
        byte[] bArr3 = wloginSimpleInfo._gender;
        this._gender = bArr3 != null ? (byte[]) bArr3.clone() : new byte[0];
        byte[] bArr4 = wloginSimpleInfo._nick;
        this._nick = bArr4 != null ? (byte[]) bArr4.clone() : new byte[0];
        byte[] bArr5 = wloginSimpleInfo._img_type;
        this._img_type = bArr5 != null ? (byte[]) bArr5.clone() : new byte[0];
        byte[] bArr6 = wloginSimpleInfo._img_format;
        this._img_format = bArr6 != null ? (byte[]) bArr6.clone() : new byte[0];
        byte[] bArr7 = wloginSimpleInfo._img_url;
        this._img_url = bArr7 != null ? (byte[]) bArr7.clone() : new byte[0];
        byte[] bArr8 = wloginSimpleInfo.mainDisplayName;
        this.mainDisplayName = bArr8 != null ? (byte[]) bArr8.clone() : new byte[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this._uin);
        parcel.writeByteArray(this._face);
        parcel.writeByteArray(this._age);
        parcel.writeByteArray(this._gender);
        parcel.writeByteArray(this._nick);
        parcel.writeByteArray(this._img_type);
        parcel.writeByteArray(this._img_format);
        parcel.writeByteArray(this._img_url);
        parcel.writeByteArray(this.mainDisplayName);
    }
}
