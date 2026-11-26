package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WUserSigInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: oicq.wlogin_sdk.request.WUserSigInfo.1
        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.WUserSigInfo createFromParcel(android.os.Parcel parcel) {
            return new oicq.wlogin_sdk.request.WUserSigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.WUserSigInfo[] newArray(int i) {
            return new oicq.wlogin_sdk.request.WUserSigInfo[i];
        }
    };
    public java.util.List _domains;
    public byte[] _fastLoginBuf;
    public byte[] _in_ksid;
    public int _login_bitmap;
    public byte[] _reserveData;
    public long _seqence;
    public int _source_type;
    public java.util.List _tickets;
    public java.util.HashMap extraLoginTLVMap;
    public java.util.HashMap extraRegTLVMap;
    public java.util.HashMap loginResultTLVMap;
    public java.util.HashMap loginTLVMap;
    public java.util.HashMap regTLVMap;
    public byte[][] stList;
    public java.lang.String uin;
    public long userSeq;

    public WUserSigInfo() {
        this.uin = "";
        this._seqence = 0L;
        this.userSeq = 0L;
        this._login_bitmap = 0;
        this._source_type = 0;
        this._domains = new java.util.ArrayList();
        this._tickets = new java.util.ArrayList();
        this.regTLVMap = new java.util.HashMap();
        this.extraLoginTLVMap = new java.util.HashMap();
        this.extraRegTLVMap = new java.util.HashMap();
        this.loginTLVMap = new java.util.HashMap();
        this.loginResultTLVMap = new java.util.HashMap();
    }

    private WUserSigInfo(android.os.Parcel parcel) {
        this.uin = "";
        this._seqence = 0L;
        this.userSeq = 0L;
        this._login_bitmap = 0;
        this._source_type = 0;
        this._domains = new java.util.ArrayList();
        this._tickets = new java.util.ArrayList();
        this.regTLVMap = new java.util.HashMap();
        this.extraLoginTLVMap = new java.util.HashMap();
        this.extraRegTLVMap = new java.util.HashMap();
        this.loginTLVMap = new java.util.HashMap();
        this.loginResultTLVMap = new java.util.HashMap();
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void get_clone(oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo) {
        if (wloginSigInfo.cacheTickets != null) {
            oicq.wlogin_sdk.tools.util.LOGI("WUserSigInfo::get_clone using cacheTickets last update stamp " + wloginSigInfo.cacheUpdateStamp, "");
            this._tickets = wloginSigInfo.cacheTickets;
            return;
        }
        this._tickets.clear();
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(2, wloginSigInfo._userA5, (byte[]) null, wloginSigInfo._userA5_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(2097152, wloginSigInfo._aqSig, (byte[]) null, wloginSigInfo._aqSig_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(8192, wloginSigInfo._userSig64, (byte[]) null, wloginSigInfo._userSig64_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(1048576, wloginSigInfo._superKey, null, wloginSigInfo._psKey_create_time, wloginSigInfo._psKey, wloginSigInfo._pt4Token));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(16384, wloginSigInfo._openkey, wloginSigInfo._openid, wloginSigInfo._openkey_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(32768, wloginSigInfo._access_token, wloginSigInfo._openid, wloginSigInfo._access_token_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(128, wloginSigInfo._userStSig, wloginSigInfo._userSt_Key, wloginSigInfo._userStSig_create_time, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(16, wloginSigInfo._userA8, (byte[]) null, wloginSigInfo._userA8_create_time, wloginSigInfo._userA8_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(512, wloginSigInfo._lsKey, (byte[]) null, wloginSigInfo._lsKey_create_time, wloginSigInfo._lsKey_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(4096, wloginSigInfo._sKey, (byte[]) null, wloginSigInfo._sKey_create_time, wloginSigInfo._sKey_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(131072, wloginSigInfo._vkey, (byte[]) null, wloginSigInfo._vkey_create_time, wloginSigInfo._vKey_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(64, wloginSigInfo._TGT, wloginSigInfo._TGTKey, wloginSigInfo._A2_create_time, wloginSigInfo._A2_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(262144, wloginSigInfo._D2, wloginSigInfo._D2Key, wloginSigInfo._D2_create_time, wloginSigInfo._D2_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(524288, wloginSigInfo._sid, (byte[]) null, wloginSigInfo._sid_create_time, wloginSigInfo._sid_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(32, wloginSigInfo._userStWebSig, (byte[]) null, wloginSigInfo._userStWebSig_create_time, wloginSigInfo._userStWebSig_expire_time));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(8388608, wloginSigInfo._pay_token, (byte[]) null, 0L, 0L));
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(16777216, wloginSigInfo._pf, wloginSigInfo._pfKey, 0L, 0L));
        java.lang.Object[] objArr = new java.lang.Object[1];
        byte[] bArr = wloginSigInfo._DA2;
        objArr[0] = java.lang.Integer.valueOf(bArr != null ? bArr.length : 0);
        oicq.wlogin_sdk.tools.util.LOGI(java.lang.String.format("WUserSigInfo.get_clone add da2 %d", objArr), "");
        this._tickets.add(new oicq.wlogin_sdk.request.Ticket(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_DA2, wloginSigInfo._DA2, (byte[]) null, 0L, 0L));
        wloginSigInfo.cacheTickets = this._tickets;
        wloginSigInfo.cacheUpdateStamp = oicq.wlogin_sdk.tools.util.get_server_cur_time();
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this._in_ksid = parcel.createByteArray();
        this._reserveData = parcel.createByteArray();
        this._fastLoginBuf = parcel.createByteArray();
        this._seqence = parcel.readLong();
        this._login_bitmap = parcel.readInt();
        this._domains = parcel.readArrayList(java.util.List.class.getClassLoader());
        parcel.readTypedList(this._tickets, oicq.wlogin_sdk.request.Ticket.CREATOR);
        android.os.Bundle bundle = parcel.readBundle();
        if (bundle != null) {
            this.regTLVMap = (java.util.HashMap) bundle.getSerializable("regTLVMap");
            this.extraLoginTLVMap = (java.util.HashMap) bundle.getSerializable("extraLoginTLVMap");
            this.extraRegTLVMap = (java.util.HashMap) bundle.getSerializable("extraRegTLVMap");
            this.loginTLVMap = (java.util.HashMap) bundle.getSerializable("loginTLVMap");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByteArray(this._in_ksid);
        parcel.writeByteArray(this._reserveData);
        parcel.writeByteArray(this._fastLoginBuf);
        parcel.writeLong(this._seqence);
        parcel.writeInt(this._login_bitmap);
        parcel.writeList(this._domains);
        parcel.writeTypedList(this._tickets);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putSerializable("regTLVMap", this.regTLVMap);
        bundle.putSerializable("extraLoginTLVMap", this.extraLoginTLVMap);
        bundle.putSerializable("extraRegTLVMap", this.extraRegTLVMap);
        bundle.putSerializable("loginTLVMap", this.loginTLVMap);
        parcel.writeBundle(bundle);
    }
}
