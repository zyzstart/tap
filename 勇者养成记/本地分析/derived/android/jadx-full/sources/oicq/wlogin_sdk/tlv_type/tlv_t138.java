package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t138 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _count = 0;

    public tlv_t138() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR;
    }

    public int get_a2_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 266) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_a8_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 258) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_d2_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 323) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_lskey_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 284) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_sid_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 356) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_skey_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 288) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_stweb_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 259) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    public int get_vkey_chg_time() {
        for (int i = 0; i < this._count; i++) {
            int i2 = i * 10;
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + i2) == 310) {
                return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4 + i2 + 2);
            }
        }
        return 0;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 4) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int32 = oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len);
        this._count = iBuf_to_int32;
        return this._body_len < (iBuf_to_int32 * 10) + 4 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
