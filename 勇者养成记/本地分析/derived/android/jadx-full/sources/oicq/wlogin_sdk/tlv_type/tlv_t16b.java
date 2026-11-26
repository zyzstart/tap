package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t16b extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t16b() {
        this._cmd = 363;
    }

    public byte[] get_tlv_16b(java.util.List list) {
        int size;
        int length;
        if (list != null) {
            size = list.size();
            length = 0;
            for (int i = 0; i < size; i++) {
                length += 2;
                if (list.get(i) != null) {
                    length += ((java.lang.String) list.get(i)).length();
                }
            }
        } else {
            size = 0;
            length = 0;
        }
        int i2 = length + 2;
        byte[] bArr = new byte[i2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, size);
        if (list != null) {
            int length2 = 2;
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3) != null) {
                    byte[] bytes = ((java.lang.String) list.get(i3)).getBytes();
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, length2, bytes.length);
                    int i4 = length2 + 2;
                    java.lang.System.arraycopy(bytes, 0, bArr, i4, bytes.length);
                    length2 = i4 + bytes.length;
                } else {
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, length2, 0);
                    length2 += 2;
                }
            }
        }
        fill_head(this._cmd);
        fill_body(bArr, i2);
        set_length();
        return get_buf();
    }
}
