package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    protected int _max = 128;
    protected int _pos = 0;
    protected int _type = 0;
    protected int _head_len = 4;
    protected int _body_len = 0;
    protected byte[] _buf = new byte[128];

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
        set_length();
    }

    public void fill_head() {
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, this._pos, this._type);
        int i = this._pos + 2;
        this._pos = i;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, i, 0);
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

    public int get_size() {
        return this._pos;
    }

    public int get_type() {
        return this._type;
    }

    public void parse() {
    }

    public int put_block(byte[] bArr, int i) {
        int length = bArr.length;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, i, length);
        int i2 = i + 2;
        java.lang.System.arraycopy(bArr, 0, this._buf, i2, length);
        return i2 + length;
    }

    public int put_int16(int i, int i2) {
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, i2, i);
        return i2 + 2;
    }

    public int put_int32(long j, int i) {
        oicq.wlogin_sdk.tools.util.int64_to_buf32(this._buf, i, j);
        return i + 4;
    }

    public int put_int64(long j, int i) {
        oicq.wlogin_sdk.tools.util.int64_to_buf(this._buf, i, j);
        return i + 8;
    }

    public int put_int8(int i, int i2) {
        oicq.wlogin_sdk.tools.util.int8_to_buf(this._buf, i2, i);
        return i2 + 1;
    }

    public int set_buf(byte[] bArr, int i) {
        if (i > this._max) {
            int i2 = i + 128;
            this._max = i2;
            this._buf = new byte[i2];
        }
        this._pos = i;
        java.lang.System.arraycopy(bArr, 0, this._buf, 0, i);
        this._type = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 0);
        this._body_len = i - this._head_len;
        try {
            parse();
            return 0;
        } catch (java.lang.Exception unused) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
    }

    public int set_data(byte[] bArr, int i) {
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
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 0, this._type);
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._body_len);
        try {
            parse();
            return 0;
        } catch (java.lang.Exception unused) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
    }

    public void set_length() {
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
    }

    public java.lang.String toString() {
        java.lang.String str = "";
        for (int i = 0; i < this._pos; i++) {
            str = (str + java.lang.Integer.toHexString((this._buf[i] >> 4) & 15)) + java.lang.Integer.toHexString(this._buf[i] & 15);
        }
        return str;
    }
}
