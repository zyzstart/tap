package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class z extends oicq.wlogin_sdk.request.oicq_request {
    public int I = 0;
    public int J = 5;

    public z(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2066;
        this.u = 1;
        this.v = "wtlogin.trans_emp";
        this.x = tVar;
        if (tVar.m != 0) {
            tVar.m = 1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(long j, oicq.wlogin_sdk.request.TransReqContext transReqContext, byte[] bArr, byte[] bArr2, long j2, long j3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        byte[] bArr3;
        byte[] bArr4;
        int i = oicq.wlogin_sdk.request.t.w;
        iA = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr5 = transReqContext._body;
            long jCurrentTimeMillis = (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac;
            if (bArr5 == null) {
                bArr5 = new byte[0];
            }
            int length = bArr5.length + 4;
            byte[] bArr6 = new byte[length];
            oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr6, 0, jCurrentTimeMillis);
            java.lang.System.arraycopy(bArr5, 0, bArr6, 4, bArr5.length);
            byte[] bArrEncrypt = bArr != null ? oicq.wlogin_sdk.tools.cryptor.encrypt(bArr6, 0, length, bArr2) : bArr6;
            if (bArrEncrypt != null && bArrEncrypt.length > 0) {
                if (oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST == transReqContext.requestEm && ((bArr3 = transReqContext.wtSessionTicketKey) == null || bArr3.length == 0 || (bArr4 = transReqContext.wtSessionTicket) == null || bArr4.length == 0)) {
                    transReqContext.requestEm = oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH;
                    oicq.wlogin_sdk.request.t.an.attr_api(2413503);
                    oicq.wlogin_sdk.tools.util.LOGI("using wt st encrypt body but no st key", "" + j);
                }
                a(j, a(bArrEncrypt, bArr != null, bArr, j2, j3, transReqContext), transReqContext.requestEm);
                iA = a(java.lang.String.valueOf(j), false, wUserSigInfo);
                if (iA != 0) {
                    break;
                }
                iA = a(transReqContext);
                if (iA == 0 && bArr != null) {
                    byte[] bArr7 = transReqContext.get_body();
                    transReqContext.set_body(oicq.wlogin_sdk.tools.cryptor.decrypt(bArr7, 0, bArr7.length, bArr2));
                }
                if (iA == 180) {
                    break;
                }
                break;
            }
            int i3 = i2 + 1;
            if (i2 >= 1) {
                break;
            }
            i2 = i3;
        }
        oicq.wlogin_sdk.tools.util.LOGI("request_transport rsp: ret=" + iA);
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00d9  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(long j, oicq.wlogin_sdk.request.TransReqContext transReqContext, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, long j3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bArr4;
        byte[] bArrEncrypt;
        int iA;
        try {
            int i = oicq.wlogin_sdk.request.t.w;
            long length = transReqContext._body.length;
            int i2 = this.E;
            this.E = i2 + 1;
            try {
                byte[] bArrA = a(length, i2, java.lang.String.valueOf(j).getBytes(), j2, j2, bArr3, new java.lang.String("wtlogin_conn_trans").getBytes(), new byte[8], 0, 0L, oicq.wlogin_sdk.request.t.A);
                byte[] bArr5 = transReqContext._body;
                long jCurrentTimeMillis = (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac;
                if (bArr5 != null) {
                    if (bArr == null) {
                        byte[] bArr6 = new byte[bArrA.length + 4 + bArr5.length];
                        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr6, 0, jCurrentTimeMillis);
                        java.lang.System.arraycopy(bArrA, 0, bArr6, 4, bArrA.length);
                        java.lang.System.arraycopy(bArr5, 0, bArr6, bArrA.length + 4, bArr5.length);
                        bArrEncrypt = bArr6;
                    } else {
                        int length2 = bArrA.length + 4 + bArr5.length;
                        byte[] bArr7 = new byte[length2];
                        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 0, jCurrentTimeMillis);
                        java.lang.System.arraycopy(bArrA, 0, bArr7, 4, bArrA.length);
                        java.lang.System.arraycopy(bArr5, 0, bArr7, bArrA.length + 4, bArr5.length);
                        bArr4 = bArr2;
                        bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr7, 0, length2, bArr4);
                    }
                    if (bArrEncrypt != null || bArrEncrypt.length <= 0) {
                        iA = 0;
                    } else {
                        try {
                            a(this.i, this.t, this.j, j, this.m, this.n, i, this.p, a(bArrEncrypt, bArr, j2, j3, 1));
                            iA = a(java.lang.String.valueOf(j), true, wUserSigInfo);
                            if (iA == 0 && (iA = a(transReqContext)) == 0 && bArr != null) {
                                byte[] bArr8 = transReqContext.get_body();
                                transReqContext.set_body(oicq.wlogin_sdk.tools.cryptor.decrypt(bArr8, 0, bArr8.length, bArr4));
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    return iA;
                }
                bArrEncrypt = new byte[0];
                bArr4 = bArr2;
                if (bArrEncrypt != null) {
                    iA = 0;
                } else {
                    iA = 0;
                }
                return iA;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public synchronized int a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bytes;
        int i = oicq.wlogin_sdk.request.t.w;
        long jCurrentTimeMillis = (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac;
        oicq.wlogin_sdk.request.t.an.commit(android.os.Build.VERSION.RELEASE, new java.lang.String(oicq.wlogin_sdk.request.t.G), "", oicq.wlogin_sdk.tools.util.buf_to_string(oicq.wlogin_sdk.tools.util.get_ksid(oicq.wlogin_sdk.request.t.t)), new java.lang.String(oicq.wlogin_sdk.request.t.E), new java.lang.String(oicq.wlogin_sdk.request.t.Q), new java.lang.String(oicq.wlogin_sdk.request.t.I), new java.lang.String(oicq.wlogin_sdk.request.t.H), oicq.wlogin_sdk.tools.util.get_release_time(), oicq.wlogin_sdk.tools.util.SDK_VERSION);
        try {
            bytes = oicq.wlogin_sdk.request.t.an.toJasonObj().toString().getBytes();
        } catch (java.lang.Throwable unused) {
            bytes = new byte[0];
        }
        if (bytes != null && bytes.length != 0) {
            byte[] bArrCompress = oicq.wlogin_sdk.tools.util.compress(bytes);
            if (bArrCompress != null && bArrCompress.length != 0) {
                int length = bArrCompress.length + 8;
                byte[] bArr4 = new byte[length];
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr4, 0, jCurrentTimeMillis);
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 4, 0);
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 5, 1);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, 6, bArrCompress.length);
                java.lang.System.arraycopy(bArrCompress, 0, bArr4, 8, bArrCompress.length);
                byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr4, 0, length, bArr3);
                if (bArrEncrypt != null && bArrEncrypt.length != 0) {
                    oicq.wlogin_sdk.report.report_t.delete_file(oicq.wlogin_sdk.request.t.t);
                    a(this.i, this.t, this.j, j, this.m, this.n, i, this.p, a(bArrEncrypt, bArr2, j2, 85L, 0));
                    int iA = a(java.lang.String.valueOf(j), true, wUserSigInfo);
                    if (iA == 0) {
                        iA = b();
                    }
                    if (iA != 0) {
                        oicq.wlogin_sdk.report.report_t.write_tofile(oicq.wlogin_sdk.request.t.an, oicq.wlogin_sdk.request.t.t);
                    } else {
                        oicq.wlogin_sdk.request.t.an.clear_t2();
                    }
                    return iA;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c A[PHI: r0
  0x004c: PHI (r0v13 int) = (r0v12 int), (r0v17 int) binds: [B:16:0x004a, B:13:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    public int a(oicq.wlogin_sdk.request.TransReqContext transReqContext) {
        int iA;
        int i = this.c;
        int i2 = this.f;
        if (i <= i2 + 2) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        int i3 = (i - i2) - 2;
        this.g = i3;
        oicq.wlogin_sdk.request.oicq_request.EncryptionMethod encryptionMethod = transReqContext.requestEm;
        if (encryptionMethod == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH) {
            oicq.wlogin_sdk.request.t tVar = this.x;
            if (tVar.m == 0) {
                iA = a(this.h, i2 + 1, i3, tVar.p);
                if (iA < 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("use ecdh decrypt_body failed");
                    iA = a(this.h, this.f + 1, this.g, this.x.c);
                    if (iA < 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed");
                    }
                }
            } else {
                iA = a(this.h, i2 + 1, i3, tVar.c);
                if (iA < 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed");
                }
            }
        } else if (encryptionMethod == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST) {
            iA = a(this.h, i2 + 1, i3, transReqContext.wtSessionTicketKey);
            if (iA < 0) {
                oicq.wlogin_sdk.request.t.an.attr_api(2494911);
                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]", "[REDACTED]");
                iA = oicq.wlogin_sdk.tools.util.E_NEWST_DECRYPT;
            }
        } else {
            oicq.wlogin_sdk.tools.util.LOGI("unknown encryption method " + transReqContext.requestEm, "");
            iA = oicq.wlogin_sdk.tools.util.E_ENCRYPTION_METHOD;
        }
        return iA < 0 ? iA : a(this.h, this.f + 1, this.g, transReqContext);
    }

    public int a(byte[] bArr, int i, int i2, oicq.wlogin_sdk.request.TransReqContext transReqContext) {
        if (i2 < this.J) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        int iC = c(bArr, i);
        a((oicq.wlogin_sdk.tools.ErrMsg) null);
        oicq.wlogin_sdk.tools.util.LOGD(oicq.wlogin_sdk.request.z.class.getName(), "type=" + iC);
        if (iC == 0) {
            int i3 = this.J;
            int i4 = i + i3;
            int i5 = i2 - i3;
            byte[] bArr2 = new byte[i5];
            java.lang.System.arraycopy(bArr, i4, bArr2, 0, i5);
            transReqContext.set_body(bArr2);
        } else if (iC == 180) {
            int i6 = i + this.J + 2;
            oicq.wlogin_sdk.tlv_type.tlv_t172 tlv_t172Var = new oicq.wlogin_sdk.tlv_type.tlv_t172();
            int i7 = tlv_t172Var.get_tlv(bArr, i6, (this.c - i6) - 1);
            if (i7 <= 0) {
                return i7;
            }
            oicq.wlogin_sdk.request.t tVar = this.x;
            tVar.m = 2;
            tVar.r = tlv_t172Var.get_data();
            oicq.wlogin_sdk.tools.util.LOGI("request_transport get rollback sig");
        }
        return iC;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public void a(java.net.Socket socket) {
        this.x.ak = socket;
    }

    byte[] a(long j, long j2, byte[] bArr, long j3, long j4, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, long j5, byte[] bArr5) {
        byte[] bArr6 = bArr2 == null ? new byte[0] : bArr2;
        int length = bArr.length + 16 + 4 + 16 + 4 + bArr6.length + 4 + bArr3.length + 4 + bArr4.length + 1 + 4 + 4 + bArr5.length + 4;
        byte[] bArr7 = new byte[length];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 0, ((long) length) + j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 4, (length - 4) - 4);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 8, j2);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, 12, bArr.length + 4);
        java.lang.System.arraycopy(bArr, 0, bArr7, 16, bArr.length);
        int length2 = bArr.length + 16;
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, length2, j3);
        int i2 = length2 + 4;
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i2, j4);
        int i3 = i2 + 16;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, i3, bArr6.length + 4);
        int i4 = i3 + 4;
        java.lang.System.arraycopy(bArr6, 0, bArr7, i4, bArr6.length);
        int length3 = i4 + bArr6.length;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, length3, bArr3.length + 4);
        int i5 = length3 + 4;
        java.lang.System.arraycopy(bArr3, 0, bArr7, i5, bArr3.length);
        int length4 = i5 + bArr3.length;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, length4, bArr4.length + 4);
        int i6 = length4 + 4;
        java.lang.System.arraycopy(bArr4, 0, bArr7, i6, bArr4.length);
        int length5 = i6 + bArr4.length;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, length5, i);
        int i7 = length5 + 1;
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i7, j5);
        int i8 = i7 + 4;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, i8, bArr5.length + 4);
        int i9 = i8 + 4;
        java.lang.System.arraycopy(bArr5, 0, bArr7, i9, bArr5.length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i9 + bArr5.length, 4 + j);
        return bArr7;
    }

    public byte[] a(byte[] bArr, boolean z, byte[] bArr2, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext) {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int i = true == z ? 1 : 0;
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = this.x.r;
        if (bArr4 != null && bArr4.length > 0) {
            byte[] bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t172().get_tlv_172(this.x.r);
            byte[] bArr6 = new byte[bArr5.length + 2];
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6, 0, 1);
            java.lang.System.arraycopy(bArr5, 0, bArr6, 2, bArr5.length);
            bArr3 = bArr6;
        }
        int length = bArr2.length + 13 + 1 + bArr3.length;
        this.I = length;
        byte[] bArr7 = new byte[bArr.length + length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, 0, i);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 1, bArr.length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 3, j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 7, j2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 11, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr7, 13, bArr2.length);
        int length2 = bArr2.length + 13;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, length2, bArr3.length);
        int i2 = length2 + 1;
        java.lang.System.arraycopy(bArr3, 0, bArr7, i2, bArr3.length);
        java.lang.System.arraycopy(bArr, 0, bArr7, i2 + bArr3.length, bArr.length);
        int length3 = bArr.length;
        return a(bArr7, transReqContext.requestEm, transReqContext.wtSessionTicket, transReqContext.wtSessionTicketKey);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, long j, long j2, int i) {
        int i2;
        if (bArr2 == null) {
            bArr2 = new byte[0];
            i2 = i == 0 ? 0 : 3;
        } else {
            i2 = i == 0 ? 1 : 2;
        }
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = this.x.r;
        if (bArr4 != null && bArr4.length > 0) {
            byte[] bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t172().get_tlv_172(this.x.r);
            byte[] bArr6 = new byte[bArr5.length + 2];
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6, 0, 1);
            java.lang.System.arraycopy(bArr5, 0, bArr6, 2, bArr5.length);
            bArr3 = bArr6;
        }
        int length = bArr2.length + 13 + 1 + bArr3.length;
        this.I = length;
        byte[] bArr7 = new byte[bArr.length + length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, 0, i2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 1, bArr.length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 3, j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, 7, j2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 11, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr7, 13, bArr2.length);
        int length2 = bArr2.length + 13;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, length2, bArr3.length);
        int i3 = length2 + 1;
        java.lang.System.arraycopy(bArr3, 0, bArr7, i3, bArr3.length);
        java.lang.System.arraycopy(bArr, 0, bArr7, i3 + bArr3.length, bArr.length);
        int length3 = bArr.length;
        return a(bArr7);
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(boolean z) {
        if (z) {
        }
        return 8080;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int d(byte[] bArr, int i, int i2) {
        if (i2 < this.J) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        int iC = c(bArr, i);
        a((oicq.wlogin_sdk.tools.ErrMsg) null);
        oicq.wlogin_sdk.tools.util.LOGD(oicq.wlogin_sdk.request.z.class.getName(), "type=" + iC);
        return iC;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public java.net.Socket d() {
        if (this.x.ak != null) {
            oicq.wlogin_sdk.tools.util.LOGD("_transport_sk", "_transport_sk" + this.x.ak.toString());
        } else {
            oicq.wlogin_sdk.tools.util.LOGD("_transport_sk", "_transport_sk null");
        }
        return this.x.ak;
    }
}
