package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TLV_SppKey extends oicq.wlogin_sdk.devicelock.e {
    public byte[] SppKey = new byte[0];

    public TLV_SppKey() {
        this._type = 11;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        this.SppKey = get_data();
    }
}
