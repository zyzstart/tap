package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends oicq.wlogin_sdk.a.a {
    public b() {
        this.b = 6;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x011a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x004f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0054. Please report as an issue. */
    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5, byte[] bArr6, boolean z, byte[] bArr7, long j, byte[] bArr8, int i2, java.util.Map map) {
        byte[] bytes;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV2;
        byte b;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV3;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV4;
        int i3 = 0;
        byte[] bArr9 = bArr6 == null ? new byte[0] : bArr6;
        byte[] bArr10 = bArr4 == null ? new byte[0] : bArr4;
        byte[] bArr11 = bArr7 == null ? new byte[0] : bArr7;
        int[] iArr = z ? new int[]{1, 5, 6, 8, 15, 37, 9, 10, 11, 13, 14} : new int[]{1, 5, 6, 8, 15, 37, 10, 13, 14};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = iArr.length;
        int i4 = 0;
        int length2 = 0;
        while (i4 < length) {
            byte[] buf = new byte[i3];
            int i5 = iArr[i4];
            if (i5 != 1) {
                if (i5 != 37) {
                    if (i5 == 5) {
                        regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(5);
                        regTLV2.setData(bArr9, bArr9.length);
                    } else if (i5 != 6) {
                        switch (i5) {
                            case 8:
                                b = 1;
                                regTLV3 = new oicq.wlogin_sdk.tlv_type.RegTLV(8);
                                regTLV3.setByte(b);
                                buf = regTLV3.getBuf();
                                break;
                            case 9:
                                regTLV3 = new oicq.wlogin_sdk.tlv_type.RegTLV(9);
                                b = 1;
                                regTLV3.setByte(b);
                                buf = regTLV3.getBuf();
                                break;
                            case 10:
                                regTLV3 = new oicq.wlogin_sdk.tlv_type.RegTLV(10);
                                regTLV3.setData(bArr11, bArr11.length);
                                buf = regTLV3.getBuf();
                                break;
                            case 11:
                                regTLV3 = new oicq.wlogin_sdk.tlv_type.RegTLV(11);
                                regTLV3.setData(bArr3, bArr3.length);
                                buf = regTLV3.getBuf();
                                break;
                            default:
                                switch (i5) {
                                    case 13:
                                        regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(13);
                                        regTLV.setInt((int) j);
                                        break;
                                    case 14:
                                        regTLV4 = new oicq.wlogin_sdk.tlv_type.RegTLV(14);
                                        regTLV4.setData(bArr8, bArr8.length);
                                        buf = regTLV4.getBuf();
                                        break;
                                    case 15:
                                        regTLV4 = new oicq.wlogin_sdk.tlv_type.RegTLV(15);
                                        regTLV4.setInt(i2);
                                        buf = regTLV4.getBuf();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                        }
                    } else {
                        regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(6);
                        regTLV.setData(bArr10, bArr10.length);
                    }
                    if (buf.length >= 2) {
                        length2 += buf.length;
                        arrayList.add(buf);
                    }
                    i4++;
                    iArr = iArr;
                    i3 = 0;
                } else {
                    regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(37);
                    regTLV2.setShort(oicq.wlogin_sdk.request.t.au);
                }
                buf = regTLV2.getBuf();
                if (buf.length >= 2) {
                    length2 += buf.length;
                    arrayList.add(buf);
                }
                i4++;
                iArr = iArr;
                i3 = 0;
            } else {
                regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(1);
                regTLV.setData(bArr5, bArr5.length);
            }
            buf = regTLV.getBuf();
            if (buf.length >= 2) {
                length2 += buf.length;
                arrayList.add(buf);
            }
            i4++;
            iArr = iArr;
            i3 = 0;
        }
        java.util.Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            byte[] buf2 = ((oicq.wlogin_sdk.tlv_type.RegTLV) map.get((java.lang.Integer) it.next())).getBuf();
            arrayList.add(buf2);
            length2 += buf2.length;
        }
        int size = arrayList.size();
        byte[] bArr12 = new byte[length2 + 2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr12, 0, (byte) size);
        oicq.wlogin_sdk.tools.util.LOGI("tlv cnt " + size, "");
        int length3 = 2;
        for (int i6 = 0; i6 < size; i6++) {
            byte[] bArr13 = (byte[]) arrayList.get(i6);
            java.lang.System.arraycopy(bArr13, 0, bArr12, length3, bArr13.length);
            length3 += bArr13.length;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(bArr.length);
            dataOutputStream.write(bArr);
            dataOutputStream.writeByte(bArr3.length);
            dataOutputStream.write(bArr3);
            dataOutputStream.writeByte(i);
            dataOutputStream.write(bArr12);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (bArr2 == null || bArr2.length <= 0) {
                oicq.wlogin_sdk.tools.util.LOGI("msgchk is null or length is 0", "");
                bytes = oicq.wlogin_sdk.a.h.f1656a.getBytes();
            } else {
                oicq.wlogin_sdk.tools.util.LOGI("msgchk is " + oicq.wlogin_sdk.tools.util.buf_to_string(bArr2, bArr2.length), "");
                bytes = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr2);
            }
            byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(byteArray, 0, byteArray.length, bytes);
            int length4 = bArr.length + 1 + 2 + bArrEncrypt.length;
            this.d = length4;
            byte[] bArr14 = new byte[length4];
            oicq.wlogin_sdk.tools.util.int8_to_buf(bArr14, 0, bArr.length);
            java.lang.System.arraycopy(bArr, 0, bArr14, 1, bArr.length);
            int length5 = bArr.length + 1;
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr14, length5, bArrEncrypt.length);
            java.lang.System.arraycopy(bArrEncrypt, 0, bArr14, length5 + 2, bArrEncrypt.length);
            int length6 = bArrEncrypt.length;
            oicq.wlogin_sdk.tools.util.LOGI("encryptedContent length " + bArrEncrypt.length, "");
            return a(bArr14);
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("get account failed " + e.getMessage(), "");
            return null;
        }
    }
}
