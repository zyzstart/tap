package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t192 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    byte[] _url = new byte[0];

    public tlv_t192() {
        this._cmd = 402;
    }

    public java.lang.String getUrl() {
        return new java.lang.String(this._url);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        int i = this._body_len;
        byte[] bArr = new byte[i];
        this._url = bArr;
        java.lang.System.arraycopy(this._buf, this._head_len, bArr, 0, i);
        return java.lang.Boolean.TRUE;
    }
}
