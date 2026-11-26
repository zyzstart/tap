package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f extends oicq.wlogin_sdk.a.a {
    public f() {
        this.b = 10;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, long j, long j2, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, long j3, byte[] bArr8, byte[] bArr9, byte[] bArr10, java.util.Map map) {
        int i4;
        int i5;
        byte[] buf;
        java.util.ArrayList arrayList;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV;
        int i6;
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV2;
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        int i7 = 0;
        byte[] bArr11 = bArr7 == null ? new byte[0] : bArr7;
        byte[] bArr12 = bArr10 == null ? new byte[0] : bArr10;
        int[] iArr = {1, 2, 3, 4, 13, 6, 7, 37};
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int length = 0;
        for (int i8 = 8; i7 < i8; i8 = 8) {
            byte[] bArr13 = new byte[0];
            int i9 = iArr[i7];
            int[] iArr2 = iArr;
            if (i9 != 6) {
                if (i9 == 7) {
                    regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(7);
                    int i10 = oicq.wlogin_sdk.request.t.ah | 0;
                    if (true == oicq.wlogin_sdk.request.t.ag) {
                        i10 |= 2;
                    }
                    i6 = i10 | 8;
                } else if (i9 != 13) {
                    if (i9 != 37) {
                        switch (i9) {
                            case 1:
                                regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(1);
                                regTLV2.setData(bArr11, bArr11.length);
                                buf = regTLV2.getBuf();
                                break;
                            case 2:
                                regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(2);
                                regTLV2.setLong(j3);
                                buf = regTLV2.getBuf();
                                break;
                            case 3:
                                regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(3);
                                regTLV2.setData(bArr8, bArr8.length);
                                buf = regTLV2.getBuf();
                                break;
                            case 4:
                                regTLV2 = new oicq.wlogin_sdk.tlv_type.RegTLV(4);
                                regTLV2.setData(bArr9, bArr9.length);
                                buf = regTLV2.getBuf();
                                break;
                            default:
                                buf = bArr13;
                                break;
                        }
                        arrayList2 = arrayList2;
                    } else {
                        oicq.wlogin_sdk.tlv_type.RegTLV regTLV3 = new oicq.wlogin_sdk.tlv_type.RegTLV(37);
                        regTLV3.setShort(oicq.wlogin_sdk.request.t.au);
                        buf = regTLV3.getBuf();
                    }
                    arrayList2 = arrayList2;
                } else {
                    regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(13);
                    i6 = (int) j2;
                }
                regTLV.setInt(i6);
                buf = regTLV.getBuf();
                bArr11 = bArr11;
            } else {
                arrayList2 = arrayList2;
                oicq.wlogin_sdk.tlv_type.RegTLV regTLV4 = new oicq.wlogin_sdk.tlv_type.RegTLV(6);
                int length2 = bArr12.length + 3;
                byte[] bArr14 = new byte[length2];
                if (bArr12.length == 0) {
                    i4 = 0;
                    i5 = 1;
                } else {
                    i4 = 0;
                    i5 = 2;
                }
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr14, i4, i5);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr14, 1, bArr12.length);
                java.lang.System.arraycopy(bArr12, 0, bArr14, 3, bArr12.length);
                int length3 = bArr12.length;
                regTLV4.setData(bArr14, length2);
                buf = regTLV4.getBuf();
            }
            if (buf.length > 4) {
                length += buf.length;
                arrayList = arrayList2;
                arrayList.add(buf);
            } else {
                arrayList = arrayList2;
            }
            i7++;
            arrayList2 = arrayList;
            iArr = iArr2;
            bArr11 = bArr11;
        }
        java.util.ArrayList arrayList3 = arrayList2;
        java.util.Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            byte[] buf2 = ((oicq.wlogin_sdk.tlv_type.RegTLV) map.get((java.lang.Integer) it.next())).getBuf();
            arrayList3.add(buf2);
            length += buf2.length;
        }
        int size = arrayList3.size();
        int length4 = 2;
        byte[] bArr15 = new byte[length + 2];
        int i11 = 0;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr15, 0, (byte) size);
        int i12 = 0;
        while (i12 < size) {
            byte[] bArr16 = (byte[]) arrayList3.get(i12);
            java.lang.System.arraycopy(bArr16, i11, bArr15, length4, bArr16.length);
            length4 += bArr16.length;
            i12++;
            i11 = 0;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(bArr.length);
            dataOutputStream.write(bArr);
            dataOutputStream.writeByte(this.c);
            dataOutputStream.writeByte(str.length());
            dataOutputStream.write(str.getBytes());
            dataOutputStream.writeByte(bArr2.length);
            dataOutputStream.write(bArr2);
            dataOutputStream.writeByte(bArr3.length);
            dataOutputStream.write(bArr3);
            dataOutputStream.writeByte(i);
            dataOutputStream.writeByte(i2);
            dataOutputStream.writeByte(i3);
            dataOutputStream.writeInt((int) j);
            if (bArr4 == null || bArr4.length != 4) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.write(bArr4);
            }
            dataOutputStream.writeByte(bArr5.length);
            dataOutputStream.write(bArr5);
            dataOutputStream.writeByte(bArr6.length);
            dataOutputStream.write(bArr6);
            dataOutputStream.write(bArr15);
            return a(byteArrayOutputStream.toByteArray());
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("get account failed " + e.getMessage(), "");
            return null;
        }
    }
}
