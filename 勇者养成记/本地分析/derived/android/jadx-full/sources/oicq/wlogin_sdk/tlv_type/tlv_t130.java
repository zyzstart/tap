package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t130 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t130() {
        this._cmd = 304;
    }

    public byte[] get_ipaddr() {
        byte[] bArr = new byte[4];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 4, bArr, 0, 4);
        return bArr;
    }

    public byte[] get_time() {
        byte[] bArr = new byte[4];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, 4);
        return bArr;
    }

    public void get_tlv_130(byte[] bArr, int i) {
        set_buf(bArr, i);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        return this._body_len < 14 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
