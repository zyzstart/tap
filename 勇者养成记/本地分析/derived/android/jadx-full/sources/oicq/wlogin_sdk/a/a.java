package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1655a = 11;
    public int b = 0;
    public int c = 5;
    public int d = 0;
    protected int e = 3;

    /* JADX WARN: Code duplicated, block: B:68:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0139 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x013a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0143  */
    public static int a(int i, byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int iBuf_to_int16;
        int iBuf_to_int17;
        int iBuf_to_int8;
        int iBuf_to_int9;
        int iBuf_to_int18;
        int iBuf_to_int19;
        int iBuf_to_int110;
        int iBuf_to_int10;
        int iBuf_to_int11;
        int i2;
        int[] iArrB = b(bArr);
        int iA = iArrB[0];
        int i3 = iArrB[1];
        if (iA == -1009) {
            return iA;
        }
        int i4 = i3 + 2;
        if (i4 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        hVar.d = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i3) & android.support.v4.internal.view.SupportMenu.USER_MASK;
        int i5 = i4 + 2;
        if (i5 > bArr.length || (iBuf_to_int17 = i5 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i4))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr2 = new byte[iBuf_to_int16];
        java.lang.System.arraycopy(bArr, i5, bArr2, 0, iBuf_to_int16);
        int i6 = iBuf_to_int17 + 1;
        if (i6 > bArr.length || (iBuf_to_int9 = i6 + (iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, iBuf_to_int17))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr3 = new byte[iBuf_to_int8];
        hVar.e = bArr3;
        java.lang.System.arraycopy(bArr, i6, bArr3, 0, iBuf_to_int8);
        int i7 = iBuf_to_int9 + 2;
        if (i7 > bArr.length || (iBuf_to_int19 = i7 + (iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int9))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr4 = new byte[iBuf_to_int18];
        hVar.f = bArr4;
        java.lang.System.arraycopy(bArr, i7, bArr4, 0, iBuf_to_int18);
        if (i == 3 && (i2 = iBuf_to_int19 + 2) <= bArr.length) {
            int iBuf_to_int111 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int19);
            oicq.wlogin_sdk.tools.util.LOGI("reg cmd 0x3 has " + iBuf_to_int111 + " tlv");
            iA = oicq.wlogin_sdk.tools.c.a(iBuf_to_int111, bArr, i2, bArr.length - i2, hVar.B);
            if (iA != 0) {
                oicq.wlogin_sdk.tools.util.LOGI("parser tlv failed " + iA, "");
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            oicq.wlogin_sdk.tools.util.LOGI("reg cmd 0x3 tlv map size " + hVar.B.size());
        }
        if (iBuf_to_int16 <= 0) {
            return iA;
        }
        int i8 = hVar.d;
        if (i8 == 0) {
            if (4 > iBuf_to_int16) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            hVar.m = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, 0);
            if (5 > iBuf_to_int16) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            int iBuf_to_int12 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, 4);
            if (iBuf_to_int12 + 5 > iBuf_to_int16) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            byte[] bArr5 = new byte[iBuf_to_int12];
            hVar.n = bArr5;
            java.lang.System.arraycopy(bArr2, 5, bArr5, 0, iBuf_to_int12);
        } else if (i8 == 31) {
            hVar.s = 0;
            hVar.t = 0;
        } else if (i8 != 44) {
            switch (i8) {
                case 2:
                    if (1 > iBuf_to_int16 || (iBuf_to_int11 = (iBuf_to_int10 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, 0)) + 1) > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    byte[] bArr6 = new byte[iBuf_to_int10];
                    hVar.o = bArr6;
                    java.lang.System.arraycopy(bArr2, 1, bArr6, 0, iBuf_to_int10);
                    int i9 = iBuf_to_int11 + 1;
                    int iBuf_to_int13 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, iBuf_to_int11);
                    int i10 = i9 + iBuf_to_int13;
                    if (i10 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    byte[] bArr7 = new byte[iBuf_to_int13];
                    hVar.p = bArr7;
                    java.lang.System.arraycopy(bArr2, i9, bArr7, 0, iBuf_to_int13);
                    int iBuf_to_int112 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i10);
                    int i11 = i10 + 2;
                    if (i11 + iBuf_to_int112 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    byte[] bArr8 = new byte[iBuf_to_int112];
                    hVar.q = bArr8;
                    java.lang.System.arraycopy(bArr2, i11, bArr8, 0, iBuf_to_int112);
                    break;
                    break;
                case 3:
                case 6:
                    if (2 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 0);
                    if (iBuf_to_int110 + 2 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    byte[] bArr9 = new byte[iBuf_to_int110];
                    hVar.r = bArr9;
                    java.lang.System.arraycopy(bArr2, 2, bArr9, 0, iBuf_to_int110);
                    break;
                case 4:
                    if (2 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    hVar.s = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 0);
                    if (4 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    hVar.t = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 2);
                    break;
                case 5:
                    if (2 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    hVar.s = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 0);
                    if (4 > iBuf_to_int16) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    hVar.t = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 2);
                    break;
                default:
                    oicq.wlogin_sdk.tools.util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
                    break;
            }
        } else {
            if (2 > iBuf_to_int16) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 0);
            if (iBuf_to_int110 + 2 > iBuf_to_int16) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            byte[] bArr10 = new byte[iBuf_to_int110];
            hVar.r = bArr10;
            java.lang.System.arraycopy(bArr2, 2, bArr10, 0, iBuf_to_int110);
        }
        return iA;
    }

    public static int a(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        return a(0, bArr, hVar);
    }

    public static int b(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int iBuf_to_int8;
        int iBuf_to_int9;
        int iBuf_to_int16;
        int iBuf_to_int17;
        int[] iArrB = b(bArr);
        int i = iArrB[0];
        int i2 = iArrB[1];
        if (i == -1009) {
            return i;
        }
        int i3 = i2 + 2;
        if (i3 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        hVar.d = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i2);
        int i4 = i3 + 1;
        if (i4 > bArr.length || (iBuf_to_int9 = i4 + (iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, i3))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr2 = new byte[iBuf_to_int8];
        hVar.e = bArr2;
        java.lang.System.arraycopy(bArr, i4, bArr2, 0, iBuf_to_int8);
        int i5 = iBuf_to_int9 + 2;
        if (i5 > bArr.length || (iBuf_to_int17 = i5 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int9))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr3 = new byte[iBuf_to_int16];
        hVar.f = bArr3;
        java.lang.System.arraycopy(bArr, i5, bArr3, 0, iBuf_to_int16);
        int i6 = iBuf_to_int17 + 2;
        if (i6 > bArr.length) {
            return 0;
        }
        int iA = oicq.wlogin_sdk.tools.c.a(oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int17), bArr, i6, bArr.length - i6, hVar.B);
        if (iA == 0) {
            return iA;
        }
        oicq.wlogin_sdk.tools.util.LOGI("parser tlv failed " + iA, "");
        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
    }

    private static int[] b(byte[] bArr) {
        if (1 > bArr.length) {
            return new int[]{oicq.wlogin_sdk.tools.util.E_PK_LEN, 0};
        }
        if (3 > bArr.length) {
            return new int[]{oicq.wlogin_sdk.tools.util.E_PK_LEN, 1};
        }
        if (oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 1) == bArr.length && 7 <= bArr.length) {
            if (8 > bArr.length) {
                return new int[]{oicq.wlogin_sdk.tools.util.E_PK_LEN, 7};
            }
            int iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, 7) + 8;
            return iBuf_to_int8 > bArr.length ? new int[]{oicq.wlogin_sdk.tools.util.E_PK_LEN, 8} : new int[]{0, iBuf_to_int8};
        }
        return new int[]{oicq.wlogin_sdk.tools.util.E_PK_LEN, 3};
    }

    public static int c(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int iBuf_to_int16;
        int iBuf_to_int17;
        int iBuf_to_int8;
        int iBuf_to_int9;
        int iBuf_to_int10;
        int i;
        int iBuf_to_int18;
        int iBuf_to_int19;
        int[] iArrB = b(bArr);
        int iA = iArrB[0];
        int i2 = iArrB[1];
        if (iA == -1009) {
            return iA;
        }
        int i3 = i2 + 2;
        if (i3 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        hVar.d = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i2);
        int i4 = i3 + 2;
        if (i4 > bArr.length || (iBuf_to_int17 = i4 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i3))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr2 = new byte[iBuf_to_int16];
        java.lang.System.arraycopy(bArr, i4, bArr2, 0, iBuf_to_int16);
        if (hVar.d == 0) {
            byte[] bArr3 = hVar.j;
            byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr2, 0, iBuf_to_int16, (bArr3 == null || bArr3.length <= 0) ? oicq.wlogin_sdk.a.h.f1656a.getBytes() : oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr3));
            if (bArrDecrypt == null || 1 > bArrDecrypt.length || (iBuf_to_int10 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArrDecrypt, 0) + 1) > bArrDecrypt.length || (i = iBuf_to_int10 + 8) > bArrDecrypt.length) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            hVar.u = oicq.wlogin_sdk.tools.util.buf_to_int64(bArrDecrypt, iBuf_to_int10);
            int i5 = i + 2;
            if (i5 > bArrDecrypt.length || (iBuf_to_int19 = i5 + (iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, i))) > bArrDecrypt.length) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            byte[] bArr4 = new byte[iBuf_to_int18];
            hVar.v = bArr4;
            java.lang.System.arraycopy(bArrDecrypt, i5, bArr4, 0, iBuf_to_int18);
            int i6 = iBuf_to_int19 + 2;
            if (i6 > bArrDecrypt.length) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            iA = oicq.wlogin_sdk.tools.c.a(oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, iBuf_to_int19), bArrDecrypt, i6, bArrDecrypt.length - i6, hVar.B);
            if (iA != 0) {
                oicq.wlogin_sdk.tools.util.LOGI("parse tlv failed " + iA, "");
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = (oicq.wlogin_sdk.tlv_type.tlv_t) hVar.B.get(new java.lang.Integer(7));
            if (tlv_tVar != null) {
                hVar.w = tlv_tVar.get_data();
            }
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar2 = (oicq.wlogin_sdk.tlv_type.tlv_t) hVar.B.get(new java.lang.Integer(12));
            if (tlv_tVar2 != null) {
                oicq.wlogin_sdk.a.h.y = oicq.wlogin_sdk.tools.util.buf_to_int64(tlv_tVar2.get_data(), 0);
            }
        }
        int i7 = iBuf_to_int17 + 1;
        if (i7 > bArr.length || (iBuf_to_int9 = i7 + (iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, iBuf_to_int17))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr5 = new byte[iBuf_to_int8];
        hVar.e = bArr5;
        java.lang.System.arraycopy(bArr, i7, bArr5, 0, iBuf_to_int8);
        int i8 = iBuf_to_int9 + 2;
        if (i8 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        int iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int9);
        if (i8 + iBuf_to_int110 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr6 = new byte[iBuf_to_int110];
        hVar.f = bArr6;
        java.lang.System.arraycopy(bArr, i8, bArr6, 0, iBuf_to_int110);
        return iA;
    }

    public static int d(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int iBuf_to_int16;
        int iBuf_to_int17;
        int[] iArrB = b(bArr);
        int i = iArrB[0];
        int i2 = iArrB[1];
        if (i == -1009) {
            return i;
        }
        int i3 = i2 + 2;
        if (i3 > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        hVar.d = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i2);
        int i4 = i3 + 2;
        if (i4 > bArr.length || (iBuf_to_int17 = i4 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i3))) > bArr.length) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        byte[] bArr2 = new byte[iBuf_to_int16];
        hVar.f = bArr2;
        java.lang.System.arraycopy(bArr, i4, bArr2, 0, iBuf_to_int16);
        int i5 = iBuf_to_int17 + 2;
        if (i5 <= bArr.length) {
            int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int17);
            if (i5 + iBuf_to_int18 > bArr.length) {
                return oicq.wlogin_sdk.tools.util.E_PK_LEN;
            }
            if (iBuf_to_int18 > 0) {
                byte[] bArr3 = new byte[iBuf_to_int18 + 2];
                java.lang.System.arraycopy(bArr, i5, bArr3, 1, iBuf_to_int18);
                bArr3[0] = 40;
                bArr3[iBuf_to_int18 + 1] = 41;
                hVar.f = new java.lang.String(hVar.f).replace("。", new java.lang.String(bArr3) + "。").getBytes();
            }
        }
        return i;
    }

    public static int e(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int[] iArrB = b(bArr);
        int i = iArrB[0];
        int i2 = iArrB[1];
        if (i == -1009) {
            return i;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr, i2, bArr.length - i2);
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(byteArrayInputStream);
        try {
            dataInputStream.readByte();
            hVar.d = dataInputStream.readShort();
            int i3 = dataInputStream.readShort();
            if (i3 != 0) {
                byte[] bArr2 = new byte[i3];
                dataInputStream.read(bArr2);
                byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr2, 0, i3, hVar.l);
                if (bArrDecrypt == null) {
                    oicq.wlogin_sdk.tools.util.LOGI("no tlv in rsp", "");
                    return -1;
                }
                int iA = oicq.wlogin_sdk.tools.c.a(oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, 0), bArrDecrypt, 2, bArrDecrypt.length - 2, hVar.B);
                if (iA != 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("parser tlv failed " + iA, "");
                    return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                }
            }
            byte[] bArr3 = new byte[dataInputStream.readByte()];
            hVar.e = bArr3;
            dataInputStream.read(bArr3);
            int i4 = dataInputStream.readShort();
            if (i4 != 0) {
                byte[] bArr4 = new byte[i4];
                hVar.f = bArr4;
                if (dataInputStream.read(bArr4) != i4) {
                    throw new java.lang.Exception("msg len " + i4 + " error");
                }
            }
            dataInputStream.close();
            byteArrayInputStream.close();
            return 0;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("parse0x10Rsp failed " + e.getMessage(), "");
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
    }

    public static int f(byte[] bArr, oicq.wlogin_sdk.a.h hVar) {
        int[] iArrB = b(bArr);
        int i = iArrB[0];
        int i2 = iArrB[1];
        if (i == -1009) {
            return i;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr, i2, bArr.length - i2);
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(byteArrayInputStream);
        try {
            dataInputStream.readByte();
            hVar.d = dataInputStream.readShort();
            int i3 = dataInputStream.readShort();
            if (i3 != 0) {
                byte[] bArr2 = new byte[i3];
                dataInputStream.read(bArr2);
                byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr2, 0, i3, hVar.l);
                if (bArrDecrypt == null) {
                    oicq.wlogin_sdk.tools.util.LOGI("no tlv in rsp", "");
                    return -1;
                }
                int iA = oicq.wlogin_sdk.tools.c.a(oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, 0), bArrDecrypt, 2, bArrDecrypt.length - 2, hVar.B);
                if (iA != 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("parser tlv failed " + iA, "");
                    return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                }
            }
            byte[] bArr3 = new byte[dataInputStream.readByte()];
            hVar.e = bArr3;
            dataInputStream.read(bArr3);
            int i4 = dataInputStream.readShort();
            if (i4 != 0) {
                byte[] bArr4 = new byte[i4];
                hVar.f = bArr4;
                if (dataInputStream.read(bArr4) != i4) {
                    throw new java.lang.Exception("msg len " + i4 + " error");
                }
            }
            dataInputStream.close();
            byteArrayInputStream.close();
            return 0;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("parse0x11Rsp failed " + e.getMessage(), "");
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
    }

    public int a() {
        return this.b;
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[this.f1655a + 2 + bArr.length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 0, 2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 1, this.f1655a + bArr.length + 2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 3, this.e);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 5, this.b);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 7, 4);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 8, 0);
        java.lang.System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, bArr.length + 12, 3);
        return bArr2;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length + 1;
        byte[] bArr3 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        return oicq.wlogin_sdk.tools.cryptor.encrypt(bArr3, 0, length, oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr2));
    }
}
