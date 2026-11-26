package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t1 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _ip_len = 4;
    int _ip_pos = 14;
    int _ip_ver = 1;
    int _t1_body_len = 20;
    byte[] IP_KEY = new byte[2];

    public tlv_t1() {
        this._cmd = 1;
    }

    public byte[] get_ip() {
        int i = this._ip_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._ip_pos, bArr, 0, i);
        return bArr;
    }

    public byte[] get_tlv_1(long j, byte[] bArr) {
        byte[] bArr2 = new byte[this._t1_body_len];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 0, this._ip_ver);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 2, oicq.wlogin_sdk.tools.util.get_rand_32());
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 6, (int) j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 10, oicq.wlogin_sdk.tools.util.get_server_cur_time());
        java.lang.System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, bArr.length + 14, 0);
        fill_head(this._cmd);
        fill_body(bArr2, this._t1_body_len);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        return this._body_len < 20 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
