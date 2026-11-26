package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DevlockBase {
    private static int _seq;
    public static oicq.wlogin_sdk.devicelock.DevlockRst rst = new oicq.wlogin_sdk.devicelock.DevlockRst();
    private int _head_len = 110;
    private int _version = 32;
    protected int _msgType = 0;
    public int Role = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_COUNTS;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f1660a = 5;
        public static int b = 7;
        public static int c = 8;
    }

    public byte[] _get_request(long j, long j2, byte[] bArr) {
        int length = this._head_len + 1 + bArr.length + 1;
        byte[] bArr2 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 0, 2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 1, length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 3, j);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 9, this._msgType);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 11, j2);
        int i = _seq;
        _seq = i + 1;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 27, i);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 39, oicq.wlogin_sdk.request.t.u);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 43, this._version);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 45, 0);
        java.lang.System.arraycopy(bArr, 0, bArr2, 111, bArr.length);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, bArr.length + 111, 3);
        return bArr2;
    }

    public int get_msgType() {
        return this._msgType;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0086 A[LOOP:0: B:11:0x0022->B:46:0x0086, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0085 A[SYNTHETIC] */
    public int parse_rsp(byte[] bArr) {
        oicq.wlogin_sdk.devicelock.e eVar;
        if (bArr != null) {
            int length = bArr.length;
            int i = this._head_len;
            if (length >= i + 2) {
                int length2 = 2;
                int length3 = (bArr.length - i) - 2;
                byte[] bArr2 = new byte[length3];
                java.lang.System.arraycopy(bArr, i + 1, bArr2, 0, length3);
                if (2 > length3) {
                    return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                }
                int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 0);
                int i2 = 0;
                for (int i3 = 0; i3 < iBuf_to_int16; i3++) {
                    byte[] bArrPickup_TLV = pickup_TLV(bArr2, length2);
                    if (bArrPickup_TLV == null) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    length2 += bArrPickup_TLV.length;
                    int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrPickup_TLV, 0);
                    if (iBuf_to_int17 == 1) {
                        eVar = rst.commRsp;
                    } else if (iBuf_to_int17 == 6) {
                        eVar = rst.smsInfo;
                    } else if (iBuf_to_int17 == 8) {
                        eVar = rst.querySig;
                    } else if (iBuf_to_int17 == 11) {
                        eVar = rst.sppKey;
                    } else if (iBuf_to_int17 == 14) {
                        eVar = rst.mbGuideInfo;
                    } else if (iBuf_to_int17 == 3) {
                        eVar = rst.devSetupInfo;
                    } else if (iBuf_to_int17 == 4) {
                        eVar = rst.mbMobileInfo;
                    } else if (iBuf_to_int17 != 18) {
                        if (iBuf_to_int17 != 19) {
                            i2 = 0;
                        } else {
                            eVar = rst.transferInfo;
                        }
                        if (i2 != 0) {
                            return i2;
                        }
                    } else {
                        eVar = rst.devGuideInfo;
                    }
                    i2 = eVar.set_buf(bArrPickup_TLV, bArrPickup_TLV.length);
                    if (i2 != 0) {
                        return i2;
                    }
                }
                return i2 == 0 ? rst.commRsp.RetCode : i2;
            }
        }
        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
    }

    public byte[] pickup_TLV(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i + 4) {
            return null;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i + 2) + 4;
        if (bArr.length < i + iBuf_to_int16) {
            return null;
        }
        byte[] bArr2 = new byte[iBuf_to_int16];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, iBuf_to_int16);
        return bArr2;
    }
}
