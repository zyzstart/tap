package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t193 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t193() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR;
    }

    public byte[] get_tlv_193(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        fill_head(this._cmd);
        fill_body(bArr, bArr.length);
        set_length();
        return get_buf();
    }
}
