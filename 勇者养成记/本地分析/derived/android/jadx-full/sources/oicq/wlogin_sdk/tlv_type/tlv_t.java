package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t implements java.io.Serializable {
    int _body_len;
    byte[] _buf;
    int _cmd;
    int _head_len;
    int _max;
    int _pos;
    int _type;

    public tlv_t() {
        this._max = 128;
        this._pos = 0;
        this._type = 0;
        this._head_len = 4;
        this._body_len = 0;
        this._buf = new byte[128];
        this._cmd = 0;
    }

    public tlv_t(int i) {
        this._max = 128;
        this._pos = 0;
        this._type = 0;
        this._head_len = 4;
        this._body_len = 0;
        this._buf = new byte[128];
        this._cmd = 0;
        this._cmd = i;
    }

    public void fill_body(byte[] bArr, int i) {
        int i2 = this._max;
        int i3 = this._head_len;
        if (i > i2 - i3) {
            int i4 = i3 + i + 64;
            this._max = i4;
            byte[] bArr2 = new byte[i4];
            java.lang.System.arraycopy(this._buf, 0, bArr2, 0, this._pos);
            this._buf = bArr2;
        }
        this._body_len = i;
        java.lang.System.arraycopy(bArr, 0, this._buf, this._pos, i);
        this._pos += i;
    }

    public void fill_head(int i) {
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, this._pos, i);
        int i2 = this._pos + 2;
        this._pos = i2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, i2, 0);
        this._pos += 2;
    }

    public byte[] get_buf() {
        int i = this._pos;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, 0, bArr, 0, i);
        return bArr;
    }

    public byte[] get_data() {
        int i = this._body_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len, bArr, 0, i);
        return bArr;
    }

    public int get_data_len() {
        return this._body_len;
    }

    public int get_tlv(byte[] bArr, int i, int i2) {
        int i3;
        int iSearch_tlv = search_tlv(bArr, i, i2, this._cmd);
        if (iSearch_tlv < 0 || this._head_len >= (i3 = i2 - (iSearch_tlv - i))) {
            return -1;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iSearch_tlv + 2);
        this._body_len = iBuf_to_int16;
        int i4 = this._head_len + iBuf_to_int16;
        if (i4 > i3) {
            return -1;
        }
        set_buf(bArr, iSearch_tlv, i4);
        return !verify().booleanValue() ? oicq.wlogin_sdk.tools.util.E_TLV_VERIFY : iSearch_tlv + this._head_len + this._body_len;
    }

    public int get_tlv(byte[] bArr, int i, int i2, byte[] bArr2) {
        int iSearch_tlv = search_tlv(bArr, i, i2, this._cmd);
        if (iSearch_tlv < 0) {
            return -1;
        }
        int i3 = i2 - (iSearch_tlv - i);
        byte[] bArr3 = new byte[i3];
        java.lang.System.arraycopy(bArr, iSearch_tlv, bArr3, 0, i3);
        return get_tlv(bArr3, i3, bArr2);
    }

    int get_tlv(byte[] bArr, int i, byte[] bArr2) {
        if (this._head_len >= i) {
            return -1;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 2);
        this._body_len = iBuf_to_int16;
        int i2 = this._head_len;
        if (i2 + iBuf_to_int16 > i) {
            return -1;
        }
        byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, i2, iBuf_to_int16, bArr2);
        if (bArrDecrypt == null) {
            return oicq.wlogin_sdk.tools.util.E_TLV_DECRYPT;
        }
        int i3 = this._head_len;
        if (bArrDecrypt.length + i3 > this._max) {
            int length = i3 + bArrDecrypt.length;
            this._max = length;
            this._buf = new byte[length];
        }
        this._pos = 0;
        java.lang.System.arraycopy(bArr, 0, this._buf, 0, this._head_len);
        int i4 = this._pos + this._head_len;
        this._pos = i4;
        java.lang.System.arraycopy(bArrDecrypt, 0, this._buf, i4, bArrDecrypt.length);
        this._pos += bArrDecrypt.length;
        this._body_len = bArrDecrypt.length;
        if (verify().booleanValue()) {
            return 0;
        }
        return oicq.wlogin_sdk.tools.util.E_TLV_VERIFY;
    }

    public int limit_len(byte[] bArr, int i) {
        if (bArr != null) {
            return bArr.length > i ? i : bArr.length;
        }
        return 0;
    }

    int search_tlv(byte[] bArr, int i, int i2, int i3) {
        int length = bArr.length;
        while (i < length) {
            int i4 = i + 2;
            if (i4 > length) {
                break;
            }
            if (oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i) == i3) {
                return i;
            }
            if (i4 + 2 > length) {
                break;
            }
            i = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i4) + 2 + i4;
        }
        return -1;
    }

    public void set_buf(byte[] bArr, int i) {
        if (i > this._max) {
            int i2 = i + 128;
            this._max = i2;
            this._buf = new byte[i2];
        }
        this._pos = i;
        java.lang.System.arraycopy(bArr, 0, this._buf, 0, i);
        this._cmd = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 0);
        this._body_len = i - this._head_len;
    }

    public void set_buf(byte[] bArr, int i, int i2) {
        if (i2 > this._max) {
            int i3 = i2 + 128;
            this._max = i3;
            this._buf = new byte[i3];
        }
        this._pos = i2;
        java.lang.System.arraycopy(bArr, i, this._buf, 0, i2);
        this._cmd = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i);
        this._body_len = i2 - this._head_len;
    }

    public void set_data(byte[] bArr, int i) {
        int i2 = this._head_len;
        int i3 = i + i2;
        if (i3 > this._max) {
            int i4 = i3 + 128;
            this._max = i4;
            byte[] bArr2 = new byte[i4];
            java.lang.System.arraycopy(this._buf, 0, bArr2, 0, i2);
            this._buf = bArr2;
        }
        int i5 = this._head_len;
        this._pos = i + i5;
        java.lang.System.arraycopy(bArr, 0, this._buf, i5, i);
        this._body_len = i;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 0, this._cmd);
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public void set_data(byte[] bArr, int i, int i2) {
        int i3 = this._head_len;
        int i4 = i2 + i3;
        if (i4 > this._max) {
            int i5 = i4 + 128;
            this._max = i5;
            byte[] bArr2 = new byte[i5];
            java.lang.System.arraycopy(this._buf, 0, bArr2, 0, i3);
            this._buf = bArr2;
        }
        int i6 = this._head_len;
        this._pos = i2 + i6;
        java.lang.System.arraycopy(bArr, i, this._buf, i6, i2);
        this._body_len = i2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 0, this._cmd);
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public void set_length() {
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
    }

    public java.lang.Boolean verify() {
        return java.lang.Boolean.TRUE;
    }
}
