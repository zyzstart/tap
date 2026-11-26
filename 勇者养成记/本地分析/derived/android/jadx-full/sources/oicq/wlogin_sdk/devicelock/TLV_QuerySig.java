package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TLV_QuerySig extends oicq.wlogin_sdk.devicelock.e {
    public byte[] QuerySig = new byte[0];

    public TLV_QuerySig() {
        this._type = 8;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        this.QuerySig = get_data();
    }
}
