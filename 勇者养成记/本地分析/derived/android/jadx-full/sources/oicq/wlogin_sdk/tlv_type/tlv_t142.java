package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t142 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _version = 0;
    int _t142_body_len = 0;

    public tlv_t142() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02;
    }

    public byte[] get_tlv_142(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int iLimit_len = limit_len(bArr, 32);
        int i = iLimit_len + 4;
        this._t142_body_len = i;
        byte[] bArr2 = new byte[i];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 0, this._version);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 2, iLimit_len);
        java.lang.System.arraycopy(bArr, 0, bArr2, 4, iLimit_len);
        fill_head(this._cmd);
        fill_body(bArr2, i);
        set_length();
        return get_buf();
    }
}
