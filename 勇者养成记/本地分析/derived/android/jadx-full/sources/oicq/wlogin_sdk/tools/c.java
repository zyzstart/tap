package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static int a(int i, byte[] bArr, int i2, int i3, java.util.Map map) {
        if (bArr.length != i2 + i3) {
            return -1;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < i && i3 > 0; i5++) {
            int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i4);
            int i6 = i4 + 2;
            int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i6);
            int i7 = i6 + 2;
            int i8 = (i3 - 2) - 2;
            if (i8 < iBuf_to_int17) {
                return -2;
            }
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(iBuf_to_int16);
            tlv_tVar.set_data(bArr, i7, iBuf_to_int17);
            map.put(new java.lang.Integer(iBuf_to_int16), tlv_tVar);
            i4 = i7 + iBuf_to_int17;
            i3 = i8 - iBuf_to_int17;
        }
        return 0;
    }
}
