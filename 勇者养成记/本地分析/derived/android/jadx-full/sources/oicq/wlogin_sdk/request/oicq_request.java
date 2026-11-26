package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class oicq_request {
    static java.lang.String[] C = {"111.30.137.20", "123.126.122.126", "123.151.176.23", "120.198.203.150", "14.17.41.156", "163.177.71.159", "101.227.130.77", "117.135.172.187", "140.207.69.123"};
    static java.lang.String[] D = {"180.163.15.182", "183.192.200.28", "223.167.105.36", "183.61.56.18", "183.232.119.221", "163.177.86.123", "123.151.92.19", "125.39.52.120", "123.126.121.172", "117.135.169.107"};
    static int F = 0;
    static java.lang.String G = "";
    static java.lang.String H = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.content.Context f1686a;
    byte w;
    public oicq.wlogin_sdk.request.t x;
    int b = 4096;
    int c = 0;
    int d = 27;
    int e = 0;
    public int f = 15;
    protected int g = 0;
    protected byte[] h = new byte[4096];
    protected int i = 8001;
    protected int j = 0;
    protected int k = 3;
    protected int l = 0;
    protected int m = 0;
    protected int n = 2;
    protected int o = 0;
    protected int p = 0;
    java.net.InetSocketAddress q = null;
    int r = 0;
    byte[] s = new byte[6144];
    protected int t = 0;
    protected int u = 0;
    protected java.lang.String v = "";
    protected oicq.wlogin_sdk.request.oicq_request.EncryptionMethod y = oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH;
    protected boolean z = false;
    protected byte[] A = new byte[0];
    protected byte[] B = new byte[0];
    int E = 0;

    public enum EncryptionMethod {
        EM_ECDH,
        EM_ST
    }

    private void a(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        a(i, i2, j, !this.z ? 7 : 135, i3, i4, i5, i6);
    }

    private void a(int i, int i2, long j, int i3, int i4, int i5, int i6, int i7) {
        int i8 = this.j + 1;
        this.j = i8;
        this.c = 0;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, 0, 2);
        int i9 = this.c + 1;
        this.c = i9;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i9, this.d + 2 + i7);
        int i10 = this.c + 2;
        this.c = i10;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i10, i);
        int i11 = this.c + 2;
        this.c = i11;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i11, i2);
        int i12 = this.c + 2;
        this.c = i12;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i12, i8);
        int i13 = this.c + 2;
        this.c = i13;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i13, (int) j);
        int i14 = this.c + 4;
        this.c = i14;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i14, 3);
        int i15 = this.c + 1;
        this.c = i15;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i15, i3);
        int i16 = this.c + 1;
        this.c = i16;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i16, i4);
        int i17 = this.c + 1;
        this.c = i17;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i17, 2);
        int i18 = this.c + 4;
        this.c = i18;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i18, i5);
        int i19 = this.c + 4;
        this.c = i19;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i19, i6);
        this.c += 4;
    }

    private void a(int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        a(i, i2, j, i3, i4, i5, bArr.length);
        a(bArr, bArr.length);
        a();
    }

    private void a(int i, long j, int i2, int i3, boolean z, boolean z2) {
        oicq.wlogin_sdk.report.report_t3 report_t3Var = new oicq.wlogin_sdk.report.report_t3();
        report_t3Var._cmd = this.t;
        report_t3Var._sub = this.u;
        report_t3Var._rst2 = i;
        report_t3Var._used = (int) (java.lang.System.currentTimeMillis() - j);
        report_t3Var._try = i3;
        java.lang.String str = H;
        report_t3Var._host = str;
        if (str == null) {
            report_t3Var._host = "";
        }
        java.net.InetSocketAddress inetSocketAddress = this.q;
        report_t3Var._ip = inetSocketAddress == null ? "" : inetSocketAddress.getAddress().getHostAddress();
        report_t3Var._port = c(z);
        report_t3Var._conn = i2;
        report_t3Var._net = oicq.wlogin_sdk.request.t.D;
        report_t3Var._str = "";
        int i4 = 0;
        report_t3Var._slen = 0;
        report_t3Var._rlen = 0;
        if (z) {
            i4 = z2 ? 2 : 1;
        }
        report_t3Var._wap = i4;
        oicq.wlogin_sdk.request.t.an.add_t3(report_t3Var);
    }

    public static void a(int i, java.lang.String str) {
        F = i;
        G = str;
    }

    private void b(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        a(i, i2, j, 69, i3, i4, i5, i6);
    }

    private void b(int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        b(i, i2, j, i3, i4, i5, bArr.length);
        a(bArr, bArr.length);
        a();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public int a(int i) {
        oicq.wlogin_sdk.request.t.b(this.x.h)._last_flowid = i;
        return i;
    }

    public int a(java.lang.String str, boolean z, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iB = this.x.e() ? b(str, z, wUserSigInfo) : e();
        if (iB == -1000) {
            oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg();
            errMsg.setMessage(oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_4));
            a(errMsg);
        }
        return iB;
    }

    public int a(oicq.wlogin_sdk.tlv_type.tlv_t161 tlv_t161Var) {
        oicq.wlogin_sdk.tlv_type.tlv_t173 tlv_t173Var = new oicq.wlogin_sdk.tlv_type.tlv_t173();
        oicq.wlogin_sdk.tlv_type.tlv_t172 tlv_t172Var = new oicq.wlogin_sdk.tlv_type.tlv_t172();
        byte[] bArr = tlv_t161Var.get_data();
        int length = bArr.length;
        if (tlv_t173Var.get_tlv(bArr, 2, length) > 0) {
            a(tlv_t173Var);
        }
        if (tlv_t172Var.get_tlv(bArr, 2, length) <= 0) {
            return 0;
        }
        oicq.wlogin_sdk.request.t tVar = this.x;
        tVar.m = 1;
        tVar.r = tlv_t172Var.get_data();
        oicq.wlogin_sdk.tools.util.LOGI("get rollback sig", "");
        return 0;
    }

    public int a(oicq.wlogin_sdk.tlv_type.tlv_t173 tlv_t173Var) {
        int iBuf_to_int16;
        int iBuf_to_int17;
        byte[] bArr = tlv_t173Var.get_data();
        if (bArr != null && bArr.length > 2) {
            int iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, 1);
            int i = 0;
            int i2 = 2;
            while (i < iBuf_to_int8) {
                int i3 = i2 + 1;
                if (bArr.length >= i3) {
                    int iBuf_to_int9 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, i2);
                    int i4 = i3 + 2;
                    if (bArr.length < i4 || bArr.length < (iBuf_to_int17 = i4 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i3)))) {
                        break;
                    }
                    byte[] bArr2 = new byte[iBuf_to_int16];
                    java.lang.System.arraycopy(bArr, i4, bArr2, 0, iBuf_to_int16);
                    int i5 = iBuf_to_int17 + 2;
                    if (bArr.length < i5) {
                        break;
                    }
                    a(iBuf_to_int9, bArr2, oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int17));
                    i++;
                    i2 = i5;
                } else {
                    break;
                }
            }
        }
        return 0;
    }

    public int a(byte[] bArr, int i, int i2, byte[] bArr2) {
        byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, i, i2, bArr2);
        if (bArrDecrypt == null) {
            return oicq.wlogin_sdk.tools.util.E_DECRYPT;
        }
        this.g = bArrDecrypt.length;
        int length = bArrDecrypt.length;
        int i3 = this.f;
        if (length + i3 + 2 > this.b) {
            int length2 = bArrDecrypt.length + i3 + 2;
            this.b = length2;
            byte[] bArr3 = new byte[length2];
            java.lang.System.arraycopy(this.h, 0, bArr3, 0, this.c);
            this.h = bArr3;
        }
        this.c = 0;
        java.lang.System.arraycopy(bArrDecrypt, 0, this.h, i, bArrDecrypt.length);
        this.c += this.f + 2 + bArrDecrypt.length;
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    public java.lang.String a(int i, boolean z) {
        java.lang.String strA;
        java.lang.String str;
        java.lang.String str2 = "";
        int i2 = i / 2;
        if (F != 0 && (str = G) != null && str.length() > 0) {
            strA = G;
        } else if (i2 < 1) {
            if (z) {
                int i3 = oicq.wlogin_sdk.request.t.D;
                if (i3 == 1) {
                    str2 = new java.lang.String(oicq.wlogin_sdk.tools.util.get_wap_server_host1(oicq.wlogin_sdk.request.t.t));
                } else if (i3 == 2) {
                    str2 = new java.lang.String(oicq.wlogin_sdk.tools.util.get_wap_server_host2(oicq.wlogin_sdk.request.t.t));
                }
            } else {
                int i4 = oicq.wlogin_sdk.request.t.D;
                if (i4 == 1) {
                    str2 = new java.lang.String(oicq.wlogin_sdk.tools.util.get_server_host1(oicq.wlogin_sdk.request.t.t));
                } else if (i4 == 2) {
                    str2 = new java.lang.String(oicq.wlogin_sdk.tools.util.get_server_host2(oicq.wlogin_sdk.request.t.t));
                }
            }
            strA = str2;
            if (strA.length() <= 0) {
                strA = b(z);
            }
        } else if (i2 < 2) {
            strA = b(z);
        } else {
            strA = a(z);
        }
        H = strA;
        return strA;
    }

    public java.lang.String a(boolean z) {
        return !z ? C[((int) (java.lang.Math.random() * 2.147483647E9d)) % C.length] : D[((int) (java.lang.Math.random() * 2.147483647E9d)) % D.length];
    }

    public void a() {
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, this.c, 3);
        this.c++;
    }

    public void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.j + 1;
        this.j = i9;
        this.c = 0;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, 0, 2);
        int i10 = this.c + 1;
        this.c = i10;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i10, this.d + 2 + i8);
        int i11 = this.c + 2;
        this.c = i11;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i11, i);
        int i12 = this.c + 2;
        this.c = i12;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i12, i2);
        int i13 = this.c + 2;
        this.c = i13;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this.h, i13, i9);
        int i14 = this.c + 2;
        this.c = i14;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i14, (int) j);
        int i15 = this.c + 4;
        this.c = i15;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i15, 3);
        int i16 = this.c + 1;
        this.c = i16;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i16, 7);
        int i17 = this.c + 1;
        this.c = i17;
        oicq.wlogin_sdk.tools.util.int8_to_buf(this.h, i17, i4);
        int i18 = this.c + 1;
        this.c = i18;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i18, i5);
        int i19 = this.c + 4;
        this.c = i19;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i19, i6);
        int i20 = this.c + 4;
        this.c = i20;
        oicq.wlogin_sdk.tools.util.int32_to_buf(this.h, i20, i7);
        this.c += 4;
    }

    public void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        a(i, i2, i3, j, i4, i5, i6, i7, bArr, bArr.length);
    }

    public void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr, int i8) {
        a(i, i2, i3, j, i4, i5, i6, i7, i8);
        a(bArr, i8);
        a();
    }

    void a(int i, byte[] bArr, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        if (i == 1) {
            int i3 = oicq.wlogin_sdk.request.t.D;
            if (i3 == 1) {
                oicq.wlogin_sdk.tools.util.set_server_host1(oicq.wlogin_sdk.request.t.t, bArr);
            } else if (i3 == 2) {
                oicq.wlogin_sdk.tools.util.set_server_host2(oicq.wlogin_sdk.request.t.t, bArr);
            }
        } else if (i == 2) {
            int i4 = oicq.wlogin_sdk.request.t.D;
            if (i4 == 1) {
                oicq.wlogin_sdk.tools.util.set_wap_server_host1(oicq.wlogin_sdk.request.t.t, bArr);
            } else if (i4 == 2) {
                oicq.wlogin_sdk.tools.util.set_wap_server_host2(oicq.wlogin_sdk.request.t.t, bArr);
            }
        }
        oicq.wlogin_sdk.tools.util.LOGI("net type:" + oicq.wlogin_sdk.request.t.D + " type:" + i + " host:" + new java.lang.String(bArr) + " port:" + i2, "" + this.x.f);
    }

    public void a(long j, byte[] bArr) {
        a(this.i, this.t, j, this.m, oicq.wlogin_sdk.request.t.w, this.p, bArr);
    }

    public void a(long j, byte[] bArr, oicq.wlogin_sdk.request.oicq_request.EncryptionMethod encryptionMethod) {
        if (encryptionMethod == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST) {
            b(j, bArr);
            return;
        }
        if (encryptionMethod == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH) {
            a(j, bArr);
            return;
        }
        oicq.wlogin_sdk.tools.util.LOGI("getRequestEncrptedPackage unknown encryption method " + encryptionMethod, "" + j);
    }

    public void a(java.net.Socket socket) {
        this.x.aj = socket;
    }

    public void a(oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo) {
        byte[] bArr;
        if (true == wloginSigInfo.isWtSessionTicketExpired() || (bArr = wloginSigInfo.wtSessionTicket) == null || wloginSigInfo.wtSessionTicketKey == null) {
            return;
        }
        this.A = (byte[]) bArr.clone();
        this.B = (byte[]) wloginSigInfo.wtSessionTicketKey.clone();
    }

    public void a(oicq.wlogin_sdk.tlv_type.tlv_t149 tlv_t149Var) {
        try {
            oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg();
            if (tlv_t149Var != null) {
                errMsg.setType(tlv_t149Var.get_type());
                errMsg.setTitle(new java.lang.String(tlv_t149Var.get_title()));
                errMsg.setMessage(new java.lang.String(tlv_t149Var.get_content()));
                errMsg.setOtherinfo(new java.lang.String(tlv_t149Var.get_otherinfo()));
                new oicq.wlogin_sdk.request.e(oicq.wlogin_sdk.request.t.t, errMsg).start();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void a(oicq.wlogin_sdk.tools.ErrMsg errMsg) {
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg(0, "", "", "");
        if (errMsg != null) {
            try {
                async_contextVarB._last_err_msg = (oicq.wlogin_sdk.tools.ErrMsg) errMsg.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg(0, "", "", "");
            }
        }
    }

    public void a(byte[] bArr, int i) {
        int i2 = this.c;
        int i3 = i + i2 + 1;
        if (i3 > this.b) {
            int i4 = i3 + 128;
            this.b = i4;
            byte[] bArr2 = new byte[i4];
            java.lang.System.arraycopy(this.h, 0, bArr2, 0, i2);
            this.h = bArr2;
        }
        java.lang.System.arraycopy(bArr, 0, this.h, this.c, i);
        this.c += i;
    }

    public byte[] a(oicq.wlogin_sdk.tlv_type.tlv_t169 tlv_t169Var) {
        oicq.wlogin_sdk.tlv_type.tlv_t106 tlv_t106Var = new oicq.wlogin_sdk.tlv_type.tlv_t106();
        oicq.wlogin_sdk.tlv_type.tlv_t10c tlv_t10cVar = new oicq.wlogin_sdk.tlv_type.tlv_t10c();
        oicq.wlogin_sdk.tlv_type.tlv_t16a tlv_t16aVar = new oicq.wlogin_sdk.tlv_type.tlv_t16a();
        oicq.wlogin_sdk.tlv_type.tlv_t145 tlv_t145Var = new oicq.wlogin_sdk.tlv_type.tlv_t145();
        byte[] bArr = tlv_t169Var.get_data();
        int length = bArr.length;
        if (tlv_t106Var.get_tlv(bArr, 2, length) < 0 || tlv_t10cVar.get_tlv(bArr, 2, length) < 0 || tlv_t16aVar.get_tlv(bArr, 2, length) < 0) {
            return null;
        }
        byte[] bArr2 = tlv_t106Var.get_buf();
        byte[] bArr3 = tlv_t10cVar.get_buf();
        byte[] bArr4 = tlv_t16aVar.get_buf();
        byte[] bArr5 = tlv_t145Var.get_tlv_145(oicq.wlogin_sdk.request.t.A);
        byte[] bArr6 = new byte[bArr2.length + 3 + bArr3.length + bArr4.length + bArr5.length];
        bArr6[0] = 64;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6, 1, 4);
        java.lang.System.arraycopy(bArr2, 0, bArr6, 3, bArr2.length);
        int length2 = bArr2.length + 3;
        java.lang.System.arraycopy(bArr3, 0, bArr6, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        java.lang.System.arraycopy(bArr4, 0, bArr6, length3, bArr4.length);
        java.lang.System.arraycopy(bArr5, 0, bArr6, length3 + bArr4.length, bArr5.length);
        int length4 = bArr5.length;
        return bArr6;
    }

    protected byte[] a(byte[] bArr) {
        oicq.wlogin_sdk.request.t tVar = this.x;
        return tVar.m == 0 ? a(bArr, tVar.c, tVar.n, tVar.p) : a(bArr, tVar.c);
    }

    byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length + 4];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 0, i);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 2, i2);
        java.lang.System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    protected byte[] a(byte[] bArr, oicq.wlogin_sdk.request.oicq_request.EncryptionMethod encryptionMethod, byte[] bArr2, byte[] bArr3) {
        if (oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST == encryptionMethod) {
            return b(bArr, bArr2, bArr3);
        }
        if (oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH == encryptionMethod) {
            return a(bArr);
        }
        oicq.wlogin_sdk.tools.util.LOGI("encryptBody unknown encryption method " + encryptionMethod, "");
        return null;
    }

    byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        int i = this.x.m == 2 ? 3 : 2;
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, bArr2);
        byte[] bArr3 = new byte[bArr2.length + 2 + 2 + 2 + bArrEncrypt.length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 0, 1);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 1, i);
        java.lang.System.arraycopy(bArr2, 0, bArr3, 2, bArr2.length);
        int length = bArr2.length + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, length, 258);
        int i2 = length + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, i2, 0);
        java.lang.System.arraycopy(bArrEncrypt, 0, bArr3, i2 + 2, bArrEncrypt.length);
        int length2 = bArrEncrypt.length;
        return bArr3;
    }

    byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, bArr3);
        byte[] bArr4 = new byte[bArr2.length + 2 + bArrEncrypt.length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, 0, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr4, 2, bArr2.length);
        java.lang.System.arraycopy(bArrEncrypt, 0, bArr4, bArr2.length + 2, bArrEncrypt.length);
        int length = bArrEncrypt.length;
        return bArr4;
    }

    byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null || bArr2 == null || bArr3 == null || bArr4 == null) {
            return new byte[0];
        }
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, bArr4);
        byte[] bArr5 = new byte[bArr2.length + 2 + 2 + 2 + bArr3.length + bArrEncrypt.length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr5, 0, 1);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr5, 1, 1);
        java.lang.System.arraycopy(bArr2, 0, bArr5, 2, bArr2.length);
        int length = bArr2.length + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, length, 258);
        int i = length + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, i, bArr3.length);
        int i2 = i + 2;
        java.lang.System.arraycopy(bArr3, 0, bArr5, i2, bArr3.length);
        java.lang.System.arraycopy(bArrEncrypt, 0, bArr5, i2 + bArr3.length, bArrEncrypt.length);
        int length2 = bArrEncrypt.length;
        return bArr5;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007f A[PHI: r5
  0x007f: PHI (r5v6 int) = (r5v5 int), (r5v8 int) binds: [B:16:0x007d, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    public int b() {
        java.lang.String str;
        java.lang.String str2;
        int i = this.c;
        int i2 = this.f;
        if (i <= i2 + 2) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        this.g = (i - i2) - 2;
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this.h, 13);
        oicq.wlogin_sdk.tools.util.LOGI("enrypt method " + this.y + " rsp flag " + iBuf_to_int16, "");
        int iA = 0;
        if (this.y == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH && iBuf_to_int16 == 0) {
            oicq.wlogin_sdk.request.t tVar = this.x;
            if (tVar.m == 0) {
                iA = a(this.h, this.f + 1, this.g, tVar.p);
                if (iA < 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("use ecdh decrypt_body failed", "");
                    iA = a(this.h, this.f + 1, this.g, this.x.c);
                    if (iA < 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed", "");
                    }
                }
            } else {
                iA = a(this.h, this.f + 1, this.g, tVar.c);
                if (iA < 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed", "");
                }
            }
        } else if (this.y == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST && 3 == iBuf_to_int16) {
            iA = a(this.h, this.f + 1, this.g, this.B);
            if (iA < 0) {
                oicq.wlogin_sdk.request.t.an.attr_api(2494911);
                oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
                if (async_contextVarB != null) {
                    oicq.wlogin_sdk.request.t tVar2 = this.x;
                    tVar2.c(tVar2.f, async_contextVarB._sappid);
                }
                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]", "[REDACTED]");
                iA = oicq.wlogin_sdk.tools.util.E_NEWST_DECRYPT;
            }
        } else {
            if (this.y == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH && true == this.z && 4 == iBuf_to_int16) {
                byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(this.h, this.f + 1, this.g, this.x.p);
                if (bArrDecrypt == null) {
                    str = "" + this.x.f;
                    str2 = "decrypted outer body failed";
                } else {
                    int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, 0);
                    if (iBuf_to_int17 > bArrDecrypt.length - 2) {
                        oicq.wlogin_sdk.tools.util.LOGI("peer public key len wrong " + iBuf_to_int17, "" + this.x.f);
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    byte[] bArr = new byte[iBuf_to_int17];
                    java.lang.System.arraycopy(bArrDecrypt, 2, bArr, 0, iBuf_to_int17);
                    byte[] bArrCalShareKeyMd5ByPeerPublicKey = new oicq.wlogin_sdk.tools.EcdhCrypt(this.f1686a).calShareKeyMd5ByPeerPublicKey(bArr);
                    if (bArrCalShareKeyMd5ByPeerPublicKey == null || bArrCalShareKeyMd5ByPeerPublicKey.length == 0) {
                        return oicq.wlogin_sdk.tools.util.E_DECRYPT;
                    }
                    byte[] bArrDecrypt2 = oicq.wlogin_sdk.tools.cryptor.decrypt(bArrDecrypt, iBuf_to_int17 + 2, (bArrDecrypt.length - 2) - iBuf_to_int17, bArrCalShareKeyMd5ByPeerPublicKey);
                    if (bArrDecrypt2 == null) {
                        oicq.wlogin_sdk.request.t.an.attr_api(2461266);
                        str = "" + this.x.f;
                        str2 = "use share key md5 decrypt failed";
                    } else {
                        byte[] bArr2 = this.h;
                        int length = bArr2.length;
                        int i3 = this.f;
                        int i4 = i3 + 2;
                        if (length < bArrDecrypt2.length + i4) {
                            int length2 = i4 + bArrDecrypt2.length;
                            this.b = length2;
                            byte[] bArr3 = new byte[length2];
                            java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i3 + 1);
                            this.h = bArr3;
                        }
                        java.lang.System.arraycopy(bArrDecrypt2, 0, this.h, this.f + 1, bArrDecrypt2.length);
                        this.c += this.f + 2 + bArrDecrypt2.length;
                    }
                }
                oicq.wlogin_sdk.tools.util.LOGI(str2, str);
                return oicq.wlogin_sdk.tools.util.E_DECRYPT;
            }
            oicq.wlogin_sdk.tools.util.LOGI("unknown encryption method " + this.y, "");
            iA = oicq.wlogin_sdk.tools.util.E_ENCRYPTION_METHOD;
        }
        return iA < 0 ? iA : d(this.h, this.f + 1, this.g);
    }

    public int b(java.lang.String str, boolean z, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_msf ...", "" + this.x.f);
        int i = this.x.l;
        byte[] bArrC = c();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int i2 = -1000;
        byte[] retData = null;
        try {
            oicq.wlogin_sdk.tools.util.LOGI("WtloginMsfListener uin:" + str + " service_cmd:" + this.v + " timeout:" + i + " flag:" + z, "" + this.x.f);
            oicq.wlogin_sdk.request.WtloginMsfListener wtloginMsfListener = new oicq.wlogin_sdk.request.WtloginMsfListener(str, this.v, bArrC, i, z, wUserSigInfo);
            java.lang.Thread thread = new java.lang.Thread(wtloginMsfListener);
            thread.start();
            thread.join(i);
            retData = wtloginMsfListener.getRetData();
            if (retData == null) {
                oicq.wlogin_sdk.tools.util.LOGI("recv data from server failed, ret=" + wtloginMsfListener.getRet(), "" + this.x.f);
            } else {
                b(retData, retData.length);
                i2 = 0;
            }
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.printException(e, "" + this.x.f);
        }
        if (this.t != 2066) {
            oicq.wlogin_sdk.report.report_t3 report_t3Var = new oicq.wlogin_sdk.report.report_t3();
            report_t3Var._cmd = this.t;
            report_t3Var._sub = this.u;
            report_t3Var._rst2 = i2;
            report_t3Var._used = (int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            report_t3Var._try = 0;
            report_t3Var._host = "";
            report_t3Var._ip = "";
            report_t3Var._port = 0;
            report_t3Var._conn = 0;
            report_t3Var._net = 0;
            report_t3Var._str = "";
            if (i2 == 0) {
                report_t3Var._slen = bArrC.length;
                report_t3Var._rlen = retData.length;
            } else {
                report_t3Var._slen = 0;
                report_t3Var._rlen = 0;
            }
            report_t3Var._wap = 3;
            oicq.wlogin_sdk.request.t.an.add_t3(report_t3Var);
        }
        oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_msf ret=" + i2, "" + this.x.f);
        return i2;
    }

    public int b(byte[] bArr) {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 1);
    }

    public java.lang.String b(boolean z) {
        java.lang.String[] strArr = new java.lang.String[2];
        if (z) {
            strArr[0] = "wlogin.qq.com";
            strArr[1] = "wlogin1.qq.com";
        } else {
            strArr[0] = "wtlogin.qq.com";
            strArr[1] = "wtlogin1.qq.com";
        }
        return strArr[java.lang.Math.abs(new java.util.Random().nextInt() % 2)];
    }

    public void b(long j, byte[] bArr) {
        b(this.i, this.t, j, this.m, oicq.wlogin_sdk.request.t.w, this.p, bArr);
    }

    public void b(byte[] bArr, int i) {
        if (i > this.b) {
            int i2 = i + 128;
            this.b = i2;
            this.h = new byte[i2];
        }
        this.c = i;
        java.lang.System.arraycopy(bArr, 0, this.h, 0, i);
    }

    byte[] b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length + 4];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 0, i);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 2, i2);
        java.lang.System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        oicq.wlogin_sdk.request.t tVar = this.x;
        return tVar.m == 0 ? a(bArr2, tVar.c, tVar.n, tVar.p) : a(bArr2, tVar.c);
    }

    protected byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, bArr2, bArr3);
    }

    public int c(boolean z) {
        if (z) {
        }
        return 443;
    }

    public int c(byte[] bArr, int i) {
        this.w = bArr[i];
        return bArr[i] & 255;
    }

    public void c(byte[] bArr, int i, int i2) {
        oicq.wlogin_sdk.tlv_type.tlv_t146 tlv_t146Var = new oicq.wlogin_sdk.tlv_type.tlv_t146();
        int i3 = tlv_t146Var.get_tlv(bArr, i, i2);
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        if (i3 >= 0) {
            async_contextVarB._last_err_msg.setTitle(new java.lang.String(tlv_t146Var.get_title()));
            async_contextVarB._last_err_msg.setMessage(new java.lang.String(tlv_t146Var.get_msg()));
            async_contextVarB._last_err_msg.setType(tlv_t146Var.get_type());
            async_contextVarB._last_err_msg.setOtherinfo(new java.lang.String(tlv_t146Var.get_errorinfo()));
        }
    }

    public byte[] c() {
        int i = this.c;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this.h, 0, bArr, 0, i);
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    public byte[] c(byte[] bArr) {
        byte[] bArrDecrypt;
        byte[] bArr2 = oicq.wlogin_sdk.request.t.B;
        if (bArr2 == null || bArr2.length <= 0) {
            bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, 0, bArr.length, "%4;7t>;28<fc.5*6".getBytes());
        } else {
            byte[] bArr3 = new byte[16];
            if (bArr2.length > 16) {
                java.lang.System.arraycopy(bArr2, 0, bArr3, 0, 16);
            } else {
                java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                int length = oicq.wlogin_sdk.request.t.B.length;
                while (length < 16) {
                    int i = length + 1;
                    bArr3[length] = (byte) i;
                    length = i;
                }
            }
            bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, 0, bArr.length, bArr3);
            if (bArrDecrypt == null || bArrDecrypt.length <= 0) {
                bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, 0, bArr.length, "%4;7t>;28<fc.5*6".getBytes());
            }
        }
        if (bArrDecrypt == null) {
            bArrDecrypt = (byte[]) bArr.clone();
        }
        if (bArrDecrypt == null || bArrDecrypt.length < 16) {
            return null;
        }
        int length2 = bArrDecrypt.length - 16;
        byte[] bArr4 = new byte[length2];
        java.lang.System.arraycopy(bArrDecrypt, 0, bArr4, 0, length2);
        byte[] bArr5 = new byte[16];
        java.lang.System.arraycopy(bArrDecrypt, length2, bArr5, 0, 16);
        oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key = bArr5;
        return bArr4;
    }

    public byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return new byte[16];
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        java.lang.System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length + 0;
        java.lang.System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        java.lang.System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        int length2 = bArr3.length;
        return oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:103:0x037d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0186  */
    /* JADX WARN: Code duplicated, block: B:340:0x0d40 A[PHI: r1 r2 r3 r5 r14 r48 r62
  0x0d40: PHI (r1v13 oicq.wlogin_sdk.request.async_context) = (r1v12 oicq.wlogin_sdk.request.async_context), (r1v22 oicq.wlogin_sdk.request.async_context) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r2v27 byte[]) = (r2v26 byte[]), (r2v30 byte[]) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r3v18 int) = (r3v17 int), (r3v24 int) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r5v34 int) = (r5v25 int), (r5v40 int) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r14v2 oicq.wlogin_sdk.tlv_type.tlv_t403) = (r14v1 oicq.wlogin_sdk.tlv_type.tlv_t403), (r14v3 oicq.wlogin_sdk.tlv_type.tlv_t403) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r48v7 char) = (r48v6 char), (r48v10 char) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]
  0x0d40: PHI (r62v7 int) = (r62v6 int), (r62v10 int) binds: [B:375:0x0eb0, B:338:0x0d3c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:417:0x0f92  */
    /* JADX WARN: Code duplicated, block: B:58:0x025a  */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x01bd. Please report as an issue. */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x025a, please report this as an issue */
    public int d(byte[] bArr, int i, int i2) throws java.lang.Throwable {
        char c;
        byte[] bArr2;
        int i3;
        int i4;
        int i5;
        int iA;
        int iB;
        char c2;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        oicq.wlogin_sdk.tlv_type.tlv_t403 tlv_t403Var;
        oicq.wlogin_sdk.tlv_type.tlv_t119 tlv_t119Var;
        oicq.wlogin_sdk.tlv_type.tlv_t113 tlv_t113Var;
        int i6;
        int i7;
        byte[] bArr3;
        byte[] bArr4;
        oicq.wlogin_sdk.tlv_type.tlv_t11a tlv_t11aVar;
        oicq.wlogin_sdk.tlv_type.tlv_t118 tlv_t118Var;
        int i8;
        byte[] openId;
        java.lang.String str;
        oicq.wlogin_sdk.tlv_type.tlv_t11a tlv_t11aVar2;
        oicq.wlogin_sdk.tlv_type.tlv_t11a tlv_t11aVar3;
        int i9;
        int i10;
        if (i2 < 5) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t105 tlv_t105Var = new oicq.wlogin_sdk.tlv_type.tlv_t105();
        oicq.wlogin_sdk.tlv_type.tlv_t113 tlv_t113Var2 = new oicq.wlogin_sdk.tlv_type.tlv_t113();
        oicq.wlogin_sdk.tlv_type.tlv_t119 tlv_t119Var2 = new oicq.wlogin_sdk.tlv_type.tlv_t119();
        oicq.wlogin_sdk.tlv_type.tlv_t10d tlv_t10dVar = new oicq.wlogin_sdk.tlv_type.tlv_t10d();
        oicq.wlogin_sdk.tlv_type.tlv_t10e tlv_t10eVar = new oicq.wlogin_sdk.tlv_type.tlv_t10e();
        oicq.wlogin_sdk.tlv_type.tlv_t10a tlv_t10aVar = new oicq.wlogin_sdk.tlv_type.tlv_t10a();
        oicq.wlogin_sdk.tlv_type.tlv_t114 tlv_t114Var = new oicq.wlogin_sdk.tlv_type.tlv_t114();
        oicq.wlogin_sdk.tlv_type.tlv_t103 tlv_t103Var = new oicq.wlogin_sdk.tlv_type.tlv_t103();
        oicq.wlogin_sdk.tlv_type.tlv_t11a tlv_t11aVar4 = new oicq.wlogin_sdk.tlv_type.tlv_t11a();
        oicq.wlogin_sdk.tlv_type.tlv_t102 tlv_t102Var = new oicq.wlogin_sdk.tlv_type.tlv_t102();
        oicq.wlogin_sdk.tlv_type.tlv_t10b tlv_t10bVar = new oicq.wlogin_sdk.tlv_type.tlv_t10b();
        oicq.wlogin_sdk.tlv_type.tlv_t11c tlv_t11cVar = new oicq.wlogin_sdk.tlv_type.tlv_t11c();
        oicq.wlogin_sdk.tlv_type.tlv_t11d tlv_t11dVar = new oicq.wlogin_sdk.tlv_type.tlv_t11d();
        oicq.wlogin_sdk.tlv_type.tlv_t120 tlv_t120Var = new oicq.wlogin_sdk.tlv_type.tlv_t120();
        oicq.wlogin_sdk.tlv_type.tlv_t121 tlv_t121Var = new oicq.wlogin_sdk.tlv_type.tlv_t121();
        oicq.wlogin_sdk.tlv_type.tlv_t130 tlv_t130Var = new oicq.wlogin_sdk.tlv_type.tlv_t130();
        oicq.wlogin_sdk.tlv_type.tlv_t108 tlv_t108Var = new oicq.wlogin_sdk.tlv_type.tlv_t108();
        oicq.wlogin_sdk.tlv_type.tlv_t106 tlv_t106Var = new oicq.wlogin_sdk.tlv_type.tlv_t106();
        oicq.wlogin_sdk.tlv_type.tlv_t10c tlv_t10cVar = new oicq.wlogin_sdk.tlv_type.tlv_t10c();
        oicq.wlogin_sdk.tlv_type.tlv_t125 tlv_t125Var = new oicq.wlogin_sdk.tlv_type.tlv_t125();
        oicq.wlogin_sdk.tlv_type.tlv_t11f tlv_t11fVar = new oicq.wlogin_sdk.tlv_type.tlv_t11f();
        oicq.wlogin_sdk.tlv_type.tlv_t138 tlv_t138Var = new oicq.wlogin_sdk.tlv_type.tlv_t138();
        oicq.wlogin_sdk.tlv_type.tlv_t132 tlv_t132Var = new oicq.wlogin_sdk.tlv_type.tlv_t132();
        oicq.wlogin_sdk.tlv_type.tlv_t149 tlv_t149Var = new oicq.wlogin_sdk.tlv_type.tlv_t149();
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var = new oicq.wlogin_sdk.tlv_type.tlv_t150();
        oicq.wlogin_sdk.tlv_type.tlv_t143 tlv_t143Var = new oicq.wlogin_sdk.tlv_type.tlv_t143();
        oicq.wlogin_sdk.tlv_type.tlv_t305 tlv_t305Var = new oicq.wlogin_sdk.tlv_type.tlv_t305();
        oicq.wlogin_sdk.tlv_type.tlv_t164 tlv_t164Var = new oicq.wlogin_sdk.tlv_type.tlv_t164();
        oicq.wlogin_sdk.tlv_type.tlv_t165 tlv_t165Var = new oicq.wlogin_sdk.tlv_type.tlv_t165();
        oicq.wlogin_sdk.tlv_type.tlv_t167 tlv_t167Var = new oicq.wlogin_sdk.tlv_type.tlv_t167();
        oicq.wlogin_sdk.tlv_type.tlv_t16a tlv_t16aVar = new oicq.wlogin_sdk.tlv_type.tlv_t16a();
        oicq.wlogin_sdk.tlv_type.tlv_t169 tlv_t169Var = new oicq.wlogin_sdk.tlv_type.tlv_t169();
        oicq.wlogin_sdk.tlv_type.tlv_t161 tlv_t161Var = new oicq.wlogin_sdk.tlv_type.tlv_t161();
        oicq.wlogin_sdk.tlv_type.tlv_t171 tlv_t171Var = new oicq.wlogin_sdk.tlv_type.tlv_t171();
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(1298);
        oicq.wlogin_sdk.tlv_type.tlv_t16d tlv_t16dVar = new oicq.wlogin_sdk.tlv_type.tlv_t16d();
        oicq.wlogin_sdk.tlv_type.tlv_t174 tlv_t174Var = new oicq.wlogin_sdk.tlv_type.tlv_t174();
        oicq.wlogin_sdk.tlv_type.tlv_t178 tlv_t178Var = new oicq.wlogin_sdk.tlv_type.tlv_t178();
        oicq.wlogin_sdk.tlv_type.tlv_t179 tlv_t179Var = new oicq.wlogin_sdk.tlv_type.tlv_t179();
        oicq.wlogin_sdk.tlv_type.tlv_t17d tlv_t17dVar = new oicq.wlogin_sdk.tlv_type.tlv_t17d();
        oicq.wlogin_sdk.tlv_type.tlv_t17e tlv_t17eVar = new oicq.wlogin_sdk.tlv_type.tlv_t17e();
        oicq.wlogin_sdk.tlv_type.tlv_t126 tlv_t126Var = new oicq.wlogin_sdk.tlv_type.tlv_t126();
        oicq.wlogin_sdk.tlv_type.tlv_t182 tlv_t182Var = new oicq.wlogin_sdk.tlv_type.tlv_t182();
        oicq.wlogin_sdk.tlv_type.tlv_t183 tlv_t183Var = new oicq.wlogin_sdk.tlv_type.tlv_t183();
        oicq.wlogin_sdk.tlv_type.tlv_t186 tlv_t186Var = new oicq.wlogin_sdk.tlv_type.tlv_t186();
        oicq.wlogin_sdk.tlv_type.tlv_t402 tlv_t402Var = new oicq.wlogin_sdk.tlv_type.tlv_t402();
        oicq.wlogin_sdk.tlv_type.tlv_t403 tlv_t403Var2 = new oicq.wlogin_sdk.tlv_type.tlv_t403();
        oicq.wlogin_sdk.tlv_type.tlv_t136 tlv_t136Var = new oicq.wlogin_sdk.tlv_type.tlv_t136();
        oicq.wlogin_sdk.tlv_type.tlv_t118 tlv_t118Var2 = new oicq.wlogin_sdk.tlv_type.tlv_t118();
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        long j = async_contextVarB._sappid;
        long j2 = async_contextVarB._appid;
        if (this.t == 2064) {
            switch (this.u) {
                case 2:
                    c = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 12:
                case 14:
                case 16:
                case 21:
                default:
                    return oicq.wlogin_sdk.tools.util.E_SYSTEM;
                case 4:
                    c = 3;
                    break;
                case 7:
                    c = 6;
                    break;
                case 9:
                case 17:
                case 19:
                case 20:
                case 22:
                    c = 0;
                    break;
                case 10:
                case 11:
                    c = 1;
                    break;
                case 13:
                    c = 4;
                    break;
                case 15:
                    c = 5;
                    break;
                case 18:
                    c = 7;
                    break;
            }
        } else {
            c = 0;
        }
        int iC = c(bArr, i + 2);
        int i11 = i + 5;
        oicq.wlogin_sdk.request.t tVar = this.x;
        tVar.d = null;
        if (iC == 41 || iC == 116) {
            bArr2 = bArr;
            i3 = i11;
            c = c;
            iC = iC;
            i4 = 1;
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar2 = new oicq.wlogin_sdk.tlv_type.tlv_t(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_TBS);
            i5 = tlv_tVar2.get_tlv(bArr2, i3, (this.c - i3) - 1);
            if (i5 < 0) {
                iA = i5;
            } else {
                oicq.wlogin_sdk.sharemem.WloginSigInfo._LHSig = tlv_tVar2.get_data();
                c(bArr2, i3, (this.c - i3) - i4);
                iA = iC;
            }
        } else if (iC != 160) {
            if (iC == 176) {
                bArr2 = bArr;
                i3 = i11;
                c = c;
                iC = iC;
                c(bArr2, i3, (this.c - i3) - 1);
                oicq.wlogin_sdk.request.t tVar2 = this.x;
                tVar2.a(tVar2.g);
            } else if (iC == 180) {
                bArr2 = bArr;
                i3 = i11;
                c = c;
                iC = iC;
                i4 = 1;
                int i12 = tlv_t161Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                if (i12 < 0) {
                    iA = i12;
                } else {
                    a(tlv_t161Var);
                    c(bArr2, i3, (this.c - i3) - i4);
                }
            } else if (iC == 204) {
                bArr2 = bArr;
                i3 = i11;
                c = c;
                iC = iC;
                async_contextVar = async_contextVarB;
                tlv_t403Var = tlv_t403Var2;
                if (tlv_t113Var2.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                    this.x.f = tlv_t113Var2.get_uin();
                    oicq.wlogin_sdk.request.t tVar3 = this.x;
                    tVar3.a(tVar3.g, java.lang.Long.valueOf(tVar3.f));
                }
                i4 = 1;
                i5 = tlv_t104Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                if (i5 >= 0) {
                    async_contextVar._t104 = tlv_t104Var;
                    i5 = tlv_t402Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                    if (i5 >= 0) {
                        async_contextVar._t402 = tlv_t402Var;
                        i5 = tlv_t403Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                        if (i5 >= 0) {
                            async_contextVar._t403 = tlv_t403Var;
                            c(bArr2, i3, (this.c - i3) - i4);
                        }
                    }
                }
                iA = i5;
            } else if (iC != 208) {
                switch (iC) {
                    case 0:
                        if (c != 1) {
                            tlv_t119Var = tlv_t119Var2;
                            if (c == 2) {
                                if (tlv_t183Var.get_tlv(bArr, i11, this.c - i11) >= 0) {
                                    async_contextVarB._msalt = tlv_t183Var.getMsalt();
                                }
                                if (f() == 3) {
                                    if (tlv_t113Var2.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        this.x.f = tlv_t113Var2.get_uin();
                                        oicq.wlogin_sdk.request.t tVar4 = this.x;
                                        tVar4.a(tVar4.g, java.lang.Long.valueOf(tVar4.f));
                                    }
                                    if (tlv_t104Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        async_contextVarB._t104 = tlv_t104Var;
                                    }
                                    bArr2 = bArr;
                                    i3 = i11;
                                    c = c;
                                    iC = iC;
                                    iA = 0;
                                } else {
                                    tlv_t113Var = tlv_t113Var2;
                                    if (tlv_t150Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        this.x.d = tlv_t150Var;
                                    }
                                    if (tlv_t161Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        a(tlv_t161Var);
                                    }
                                    i6 = tlv_t119Var.get_tlv(bArr, i11, (this.c - i11) - 1, async_contextVarB._tgtgt_key);
                                }
                            } else {
                                j = j;
                                tlv_t113Var = tlv_t113Var2;
                                if (c == 3 || c == 7) {
                                    c = c;
                                    iC = iC;
                                    i3 = i11;
                                    bArr2 = bArr;
                                    if (tlv_t183Var.get_tlv(bArr2, i3, this.c - i11) >= 0) {
                                        async_contextVarB._msalt = tlv_t183Var.getMsalt();
                                    }
                                    if (tlv_t113Var.get_tlv(bArr2, i3, this.c - i3) >= 0) {
                                        this.x.f = tlv_t113Var.get_uin();
                                        oicq.wlogin_sdk.request.t tVar5 = this.x;
                                        tVar5.a(tVar5.g, java.lang.Long.valueOf(tVar5.f));
                                    }
                                    iA = tlv_t104Var.get_tlv(bArr2, i3, this.c - i3);
                                    if (iA >= 0) {
                                        async_contextVarB._t104 = tlv_t104Var;
                                        iA = 0;
                                    }
                                } else if (22 == this.u) {
                                    i7 = tlv_t104Var.get_tlv(bArr, i11, this.c - i11);
                                    if (i7 < 0) {
                                        i3 = i11;
                                        c = c;
                                        iC = iC;
                                        iA = i7;
                                        bArr2 = bArr;
                                    } else {
                                        async_contextVarB._t104 = tlv_t104Var;
                                        bArr2 = bArr;
                                        i3 = i11;
                                        c = c;
                                        iC = iC;
                                        iA = 0;
                                    }
                                } else {
                                    if (tlv_t150Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        this.x.d = tlv_t150Var;
                                    }
                                    if (tlv_t161Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        a(tlv_t161Var);
                                    }
                                    i6 = tlv_t119Var.get_tlv(bArr, i11, (this.c - i11) - 1, async_contextVarB._tgtgt_key);
                                    oicq.wlogin_sdk.request.s.I = 0;
                                }
                            }
                        } else {
                            if (tVar.b == null) {
                                return oicq.wlogin_sdk.tools.util.E_NO_TGTKEY;
                            }
                            if (tlv_t150Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                this.x.d = tlv_t150Var;
                            }
                            if (tlv_t161Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                a(tlv_t161Var);
                            }
                            tlv_t119Var = tlv_t119Var2;
                            i6 = tlv_t119Var.get_tlv(bArr, i11, (this.c - i11) - 1, this.x.b);
                            j = j;
                            tlv_t113Var = tlv_t113Var2;
                        }
                        if (i6 < 0) {
                            bArr2 = bArr;
                            i3 = i11;
                            c = c;
                            iC = iC;
                            iA = i6;
                        } else {
                            byte[] bArr5 = tlv_t119Var.get_data();
                            int length = bArr5.length;
                            if (tlv_t149Var.get_tlv(bArr5, 2, length) > 0) {
                                a(tlv_t149Var);
                            }
                            if (tlv_t130Var.get_tlv(bArr5, 2, length) > 0) {
                                this.x.a(tlv_t130Var.get_time(), tlv_t130Var.get_ipaddr());
                            }
                            if (tlv_t113Var.get_tlv(bArr5, 2, length) >= 0) {
                                this.x.f = tlv_t113Var.get_uin();
                                oicq.wlogin_sdk.request.t tVar6 = this.x;
                                tVar6.a(tVar6.g, java.lang.Long.valueOf(tVar6.f));
                            }
                            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar3 = new oicq.wlogin_sdk.tlv_type.tlv_t(1320);
                            if (tlv_tVar3.get_tlv(bArr5, 2, length) > 0) {
                                oicq.wlogin_sdk.tools.util.LOGI("get tlv528 and put into context from seq " + this.x.h, "" + this.x.f);
                                async_contextVarB.tlv528 = tlv_tVar3;
                            }
                            tlv_t10dVar.get_tlv(bArr5, 2, length);
                            tlv_t10eVar.get_tlv(bArr5, 2, length);
                            tlv_t10aVar.get_tlv(bArr5, 2, length);
                            tlv_t114Var.get_tlv(bArr5, 2, length);
                            int i13 = tlv_t11aVar4.get_tlv(bArr5, 2, length);
                            if (i13 < 0) {
                                bArr2 = bArr;
                                i3 = i11;
                                c = c;
                                iC = iC;
                                iA = i13;
                            } else {
                                if (tlv_t118Var2.get_tlv(bArr5, 2, length) < 0) {
                                    oicq.wlogin_sdk.tools.util.LOGI("t118 get failed", "" + this.x.f);
                                }
                                byte[] bArr6 = tlv_t103Var.get_tlv(bArr5, 2, length) >= 0 ? tlv_t103Var.get_data() : null;
                                if (r38.get_tlv(bArr5, 2, length) >= 0) {
                                    oicq.wlogin_sdk.tools.util.set_ksid(oicq.wlogin_sdk.request.t.t, tlv_t108Var.get_data());
                                }
                                byte[] bArr7 = tlv_t102Var.get_tlv(bArr5, 2, length) >= 0 ? tlv_t102Var.get_data() : null;
                                byte[] bArr8 = r30.get_tlv(bArr5, 2, length) >= 0 ? tlv_t10bVar.get_data() : null;
                                byte[] bArr9 = r29.get_tlv(bArr5, 2, length) >= 0 ? tlv_t11cVar.get_data() : null;
                                byte[] bArr10 = r27.get_tlv(bArr5, 2, length) >= 0 ? tlv_t120Var.get_data() : null;
                                byte[] bArr11 = r28.get_tlv(bArr5, 2, length) >= 0 ? tlv_t121Var.get_data() : null;
                                if (r33.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr3 = r33.get_openid();
                                    bArr4 = tlv_t125Var.get_openkey();
                                } else {
                                    bArr3 = null;
                                    bArr4 = null;
                                }
                                if (r58.get_tlv(bArr5, 2, length) >= 0) {
                                    java.lang.String strE = this.x.g;
                                    if (oicq.wlogin_sdk.tools.util.check_uin_account(strE).booleanValue()) {
                                        oicq.wlogin_sdk.request.t tVar7 = this.x;
                                        tlv_t11aVar2 = tlv_t11aVar4;
                                        tlv_t118Var = tlv_t118Var2;
                                        strE = tVar7.e(tVar7.f);
                                        if (strE == null || strE.length() <= 0) {
                                            tlv_t11aVar3 = tlv_t11aVar2;
                                        }
                                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                        sb.append("put t186: name: ");
                                        sb.append(strE);
                                        sb.append(" uin: ");
                                        tlv_t11aVar = tlv_t11aVar3;
                                        sb.append(this.x.f);
                                        sb.append(" pwd=");
                                        sb.append(r58.getPwdflag());
                                        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
                                    } else {
                                        tlv_t11aVar2 = tlv_t11aVar4;
                                        tlv_t118Var = tlv_t118Var2;
                                    }
                                    oicq.wlogin_sdk.request.t tVar8 = this.x;
                                    tlv_t11aVar3 = tlv_t11aVar2;
                                    tVar8.a(strE, java.lang.Long.valueOf(tVar8.f), tlv_t186Var.getPwdflag());
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                    sb2.append("put t186: name: ");
                                    sb2.append(strE);
                                    sb2.append(" uin: ");
                                    tlv_t11aVar = tlv_t11aVar3;
                                    sb2.append(this.x.f);
                                    sb2.append(" pwd=");
                                    sb2.append(r58.getPwdflag());
                                    oicq.wlogin_sdk.tools.util.LOGI(sb2.toString(), "");
                                } else {
                                    async_contextVarB = async_contextVarB;
                                    tlv_t11aVar = tlv_t11aVar4;
                                    tlv_t118Var = tlv_t118Var2;
                                }
                                oicq.wlogin_sdk.tools.util.LOGI("tgt len:" + oicq.wlogin_sdk.tools.util.buf_len(tlv_t10aVar.get_data()) + " tgt_key len:" + oicq.wlogin_sdk.tools.util.buf_len(tlv_t10dVar.get_data()) + " st len:" + oicq.wlogin_sdk.tools.util.buf_len(tlv_t114Var.get_data()) + " st_key len:" + oicq.wlogin_sdk.tools.util.buf_len(tlv_t10eVar.get_data()) + " stwx_web len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr6) + " lskey len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr9) + " skey len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr10) + " sig64 len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr11) + " openid len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr3) + " openkey len:" + oicq.wlogin_sdk.tools.util.buf_len(bArr4) + " pwdflag: " + r58.get_data_len() + " " + r58.getPwdflag(), "" + this.x.f);
                                if (tlv_t169Var.get_tlv(bArr5, 2, length) >= 0) {
                                    byte[] bArrA = a(tlv_t169Var);
                                    if (bArrA == null || bArrA.length <= 0) {
                                        this.x.j = new oicq.wlogin_sdk.request.WFastLoginInfo();
                                    } else {
                                        this.x.j = new oicq.wlogin_sdk.request.WFastLoginInfo(bArrA);
                                    }
                                }
                                int i14 = 0;
                                byte[][] bArr12 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 3, 0);
                                if (tlv_t167Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr12[0] = tlv_t167Var.get_img_type();
                                    bArr12[1] = tlv_t167Var.get_img_format();
                                    bArr12[2] = tlv_t167Var.get_img_url();
                                }
                                byte[][] bArr13 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 5, 0);
                                int i15 = 0;
                                for (int i16 = 5; i15 < i16; i16 = 5) {
                                    bArr13[i15] = new byte[i14];
                                    i15++;
                                    i14 = 0;
                                }
                                int i17 = tlv_t10cVar.get_tlv(bArr5, 2, length);
                                if (tlv_t106Var.get_tlv(bArr5, 2, length) >= 0 && i17 >= 0) {
                                    bArr13[0] = (byte[]) b(tlv_t106Var.get_data(), tlv_t10cVar.get_data()).clone();
                                }
                                if (tlv_t16aVar.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr13[1] = tlv_t16aVar.get_data();
                                }
                                if (tlv_t403Var2.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr13[4] = tlv_t403Var2.get_data();
                                }
                                oicq.wlogin_sdk.request.async_context async_contextVar2 = async_contextVarB;
                                if (async_contextVar2._sec_guid_flag) {
                                    bArr13[2] = async_contextVar2._G;
                                    bArr13[3] = async_contextVar2._dpwd;
                                    bArr13[4] = async_contextVar2._t403.get_data();
                                    i8 = 0;
                                    async_contextVar2._sec_guid_flag = false;
                                } else {
                                    i8 = 0;
                                }
                                byte[][] bArr14 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 15, i8);
                                int i18 = 0;
                                for (int i19 = 15; i18 < i19; i19 = 15) {
                                    bArr14[i18] = new byte[0];
                                    i18++;
                                }
                                if (tlv_t136Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[0] = tlv_t136Var.get_data();
                                }
                                if (tlv_t132Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[1] = tlv_t132Var.get_access_token();
                                    bArr3 = tlv_t132Var.get_openid();
                                }
                                if (tlv_t143Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[2] = tlv_t143Var.get_data();
                                }
                                if (tlv_t305Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[3] = tlv_t305Var.get_data();
                                }
                                if (tlv_t164Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[4] = tlv_t164Var.get_data();
                                }
                                if (tlv_t171Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[5] = tlv_t171Var.get_data();
                                }
                                if (tlv_tVar.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[6] = tlv_tVar.get_data();
                                }
                                if (tlv_t16dVar.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[7] = tlv_t16dVar.get_data();
                                }
                                oicq.wlogin_sdk.tlv_type.tlv_t199 tlv_t199Var = new oicq.wlogin_sdk.tlv_type.tlv_t199();
                                if (tlv_t199Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[8] = tlv_t199Var.getPayToken();
                                    openId = tlv_t199Var.getOpenId();
                                } else {
                                    openId = bArr3;
                                }
                                oicq.wlogin_sdk.tlv_type.tlv_t200 tlv_t200Var = new oicq.wlogin_sdk.tlv_type.tlv_t200();
                                if (tlv_t200Var.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[9] = tlv_t200Var.getPf();
                                    bArr14[10] = tlv_t200Var.getPfKey();
                                }
                                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar4 = new oicq.wlogin_sdk.tlv_type.tlv_t(515);
                                if (tlv_tVar4.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[11] = tlv_tVar4.get_data();
                                    str = "get DA2 in rsp";
                                } else {
                                    str = "no DA2 in rsp";
                                }
                                oicq.wlogin_sdk.tools.util.LOGI(str, "");
                                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar5 = new oicq.wlogin_sdk.tlv_type.tlv_t(791);
                                if (tlv_tVar5.get_tlv(bArr5, 2, length) >= 0) {
                                    oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = tlv_tVar5.get_data();
                                } else {
                                    oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = new byte[0];
                                }
                                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar6 = new oicq.wlogin_sdk.tlv_type.tlv_t(com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE);
                                if (tlv_tVar6.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[13] = tlv_tVar6.get_data();
                                } else {
                                    oicq.wlogin_sdk.tools.util.LOGW("get t133 failed", "" + this.x.f);
                                }
                                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar7 = new oicq.wlogin_sdk.tlv_type.tlv_t(com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
                                if (tlv_tVar7.get_tlv(bArr5, 2, length) >= 0) {
                                    bArr14[14] = tlv_tVar7.get_data();
                                } else {
                                    oicq.wlogin_sdk.tools.util.LOGW("get t134 failed", "" + this.x.f);
                                }
                                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr13[0]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr13[1]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr13[2]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr13[3]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr13[4]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[0]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(openId) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[1]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[2]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[3]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[4]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[5]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[6]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[7]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[8]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[9]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[10]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[11]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[13]) + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_len(bArr14[14]), "[REDACTED]" + this.x.f);
                                long j3 = tlv_t11fVar.get_tlv(bArr5, 2, length) >= 0 ? ((long) tlv_t11fVar.get_tk_pri()) & 4294967295L : 4294967295L;
                                long[] jArr = new long[7];
                                int i20 = 2;
                                long j4 = 2160000;
                                while (true) {
                                    i20 = tlv_t138Var.get_tlv(bArr5, i20, length);
                                    if (i20 < 0) {
                                        long j5 = j3;
                                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                        sb3.append("sappid:");
                                        sb3.append(j);
                                        sb3.append(" appid:");
                                        sb3.append(j2);
                                        sb3.append(" app_pri:");
                                        sb3.append(j5);
                                        sb3.append(" login_bitmap:");
                                        sb3.append(async_contextVar2._login_bitmap);
                                        sb3.append(" tk_valid:");
                                        sb3.append(0L);
                                        sb3.append(" a2_valid:");
                                        long j6 = j4;
                                        sb3.append(j6);
                                        sb3.append(" lskey_valid:");
                                        sb3.append(jArr[0]);
                                        sb3.append(" skey_valid:");
                                        sb3.append(jArr[1]);
                                        sb3.append(" vkey_valid:");
                                        sb3.append(jArr[2]);
                                        sb3.append(" a8_valid:");
                                        sb3.append(jArr[3]);
                                        sb3.append(" stweb_valid:");
                                        sb3.append(jArr[4]);
                                        sb3.append(" d2_valid:");
                                        sb3.append(jArr[5]);
                                        sb3.append(" sid_valid:");
                                        sb3.append(jArr[6]);
                                        oicq.wlogin_sdk.tools.util.LOGI(sb3.toString(), "" + this.x.f);
                                        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
                                        wloginSimpleInfo.setUin(this.x.f);
                                        wloginSimpleInfo.setFace(tlv_t11aVar.get_face());
                                        wloginSimpleInfo.setAge(tlv_t11aVar.get_age());
                                        wloginSimpleInfo.setGender(tlv_t11aVar.get_gender());
                                        wloginSimpleInfo.setNick(tlv_t11aVar.get_nick());
                                        wloginSimpleInfo.setReserveUinInfo(bArr12);
                                        wloginSimpleInfo.setMainDisplayName(tlv_t118Var.get_data());
                                        oicq.wlogin_sdk.request.t tVar9 = this.x;
                                        tVar9.aq = async_contextVar2._main_sigmap;
                                        iA = tVar9.a(tVar9.f, j, bArr13, j2, j5, oicq.wlogin_sdk.request.t.f(), oicq.wlogin_sdk.request.t.f() + 0, oicq.wlogin_sdk.request.t.f() + j6, wloginSimpleInfo, tlv_t10aVar.get_data(), tlv_t10dVar.get_data(), tlv_t114Var.get_data(), tlv_t10eVar.get_data(), bArr6, bArr8, bArr7, bArr9, bArr10, bArr11, openId, bArr4, bArr14, jArr, async_contextVar2._login_bitmap);
                                        if (iA != 0) {
                                            oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg();
                                            errMsg.setMessage(oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_2));
                                            a(errMsg);
                                            oicq.wlogin_sdk.tools.util.LOGI("put_siginfo fail,ret=" + iA, "" + this.x.f);
                                            i3 = i11;
                                            bArr2 = bArr;
                                        } else {
                                            int i21 = 2;
                                            while (true) {
                                                i21 = tlv_t11dVar.get_tlv(bArr5, i21, length);
                                                if (i21 < 0) {
                                                    i3 = i11;
                                                    bArr2 = bArr;
                                                    iA = 0;
                                                } else {
                                                    oicq.wlogin_sdk.request.t tVar10 = this.x;
                                                    tVar10.a(tVar10.f, tlv_t11dVar.get_appid(), oicq.wlogin_sdk.request.t.f(), oicq.wlogin_sdk.request.t.f() + 0, tlv_t11dVar.get_st(), tlv_t11dVar.get_stkey());
                                                }
                                            }
                                        }
                                    } else {
                                        if (tlv_t138Var.get_a2_chg_time() != 0) {
                                            j4 = tlv_t138Var.get_a2_chg_time();
                                        }
                                        if (tlv_t138Var.get_lskey_chg_time() != 0) {
                                            jArr[0] = tlv_t138Var.get_lskey_chg_time();
                                        } else {
                                            jArr[0] = 1641600;
                                        }
                                        if (tlv_t138Var.get_skey_chg_time() != 0) {
                                            jArr[1] = tlv_t138Var.get_skey_chg_time();
                                        } else {
                                            jArr[1] = 86400;
                                        }
                                        if (tlv_t138Var.get_vkey_chg_time() != 0) {
                                            jArr[2] = tlv_t138Var.get_vkey_chg_time();
                                        } else {
                                            jArr[2] = 1728000;
                                        }
                                        if (tlv_t138Var.get_a8_chg_time() != 0) {
                                            jArr[3] = tlv_t138Var.get_a8_chg_time();
                                        } else {
                                            jArr[3] = 72000;
                                        }
                                        if (tlv_t138Var.get_stweb_chg_time() != 0) {
                                            jArr[4] = tlv_t138Var.get_stweb_chg_time();
                                        } else {
                                            jArr[4] = 6000;
                                        }
                                        if (tlv_t138Var.get_d2_chg_time() != 0) {
                                            jArr[5] = tlv_t138Var.get_d2_chg_time();
                                        } else {
                                            jArr[5] = 1728000;
                                        }
                                        if (tlv_t138Var.get_sid_chg_time() != 0) {
                                            jArr[6] = tlv_t138Var.get_sid_chg_time();
                                        } else {
                                            jArr[6] = 1728000;
                                        }
                                        j3 = j3;
                                    }
                                }
                            }
                        }
                        break;
                    case 1:
                        oicq.wlogin_sdk.tools.util.LOGI("cmd " + java.lang.Integer.toHexString(this.t) + " subcmd " + java.lang.Integer.toHexString(this.u) + " result " + iC + " will clean sig for uin " + this.x.f + " appid " + j);
                        oicq.wlogin_sdk.request.t tVar11 = this.x;
                        tVar11.e(tVar11.f, j);
                        i10 = this.c - i11;
                        i9 = 1;
                        c(bArr, i11, i10 - i9);
                        bArr2 = bArr;
                        i3 = i11;
                        c = c;
                        iC = iC;
                        break;
                    case 2:
                        i7 = tlv_t104Var.get_tlv(bArr, i11, (this.c - i11) - 1);
                        if (i7 >= 0) {
                            async_contextVarB._t104 = tlv_t104Var;
                            oicq.wlogin_sdk.tlv_type.tlv_t192 tlv_t192Var = new oicq.wlogin_sdk.tlv_type.tlv_t192();
                            if (tlv_t192Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                a(new oicq.wlogin_sdk.tools.ErrMsg(iC, "", "", tlv_t192Var.getUrl()));
                            } else {
                                i7 = tlv_t105Var.get_tlv(bArr, i11, (this.c - i11) - 1);
                                if (i7 >= 0) {
                                    async_contextVarB._t105 = tlv_t105Var;
                                    if (tlv_t165Var.get_tlv(bArr, i11, (this.c - i11) - 1) >= 0) {
                                        async_contextVarB._t165 = tlv_t165Var;
                                    } else {
                                        async_contextVarB._t165 = new oicq.wlogin_sdk.tlv_type.tlv_t165();
                                    }
                                    a((oicq.wlogin_sdk.tools.ErrMsg) null);
                                }
                            }
                            bArr2 = bArr;
                            i3 = i11;
                            c = c;
                            iC = iC;
                        }
                        i3 = i11;
                        c = c;
                        iC = iC;
                        iA = i7;
                        bArr2 = bArr;
                        break;
                    default:
                        switch (iC) {
                            case 15:
                                oicq.wlogin_sdk.tools.util.LOGI("cmd " + java.lang.Integer.toHexString(this.t) + " subcmd " + java.lang.Integer.toHexString(this.u) + " result " + iC + " will clean sig for uin " + this.x.f + " appid " + j);
                                oicq.wlogin_sdk.request.t tVar12 = this.x;
                                tVar12.e(tVar12.f, j);
                                i10 = this.c - i11;
                                i9 = 1;
                                c(bArr, i11, i10 - i9);
                                bArr2 = bArr;
                                i3 = i11;
                                c = c;
                                iC = iC;
                                break;
                            case 16:
                                i9 = 1;
                                tVar.e(tVar.f, j);
                                int i22 = tlv_t130Var.get_tlv(bArr, i11, (this.c - i11) - 1);
                                if (i22 < 0) {
                                    bArr2 = bArr;
                                    i3 = i11;
                                    c = c;
                                    iC = iC;
                                    iA = i22;
                                } else {
                                    this.x.a(tlv_t130Var.get_time(), tlv_t130Var.get_ipaddr());
                                    i10 = this.c - i11;
                                    c(bArr, i11, i10 - i9);
                                    bArr2 = bArr;
                                    i3 = i11;
                                    c = c;
                                    iC = iC;
                                }
                                break;
                            default:
                                i10 = this.c - i11;
                                i9 = 1;
                                c(bArr, i11, i10 - i9);
                                bArr2 = bArr;
                                i3 = i11;
                                c = c;
                                iC = iC;
                                break;
                        }
                        break;
                }
            } else {
                bArr2 = bArr;
                i3 = i11;
                c = c;
                iC = iC;
                int i23 = tlv_t104Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                if (i23 >= 0) {
                    async_contextVarB._t104 = tlv_t104Var;
                    i23 = tlv_t126Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                    if (i23 >= 0) {
                        async_contextVarB._t126 = tlv_t126Var;
                        i23 = tlv_t182Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                        if (i23 >= 0) {
                            async_contextVarB._smslogin_msgcnt = tlv_t182Var.getMsgCnt();
                            async_contextVarB._smslogin_timelimit = tlv_t182Var.getTimeLimit();
                            i23 = tlv_t183Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                            if (i23 >= 0) {
                                async_contextVarB._msalt = tlv_t183Var.getMsalt();
                                iA = 0;
                            }
                        }
                    }
                }
                iA = i23;
            }
            iA = iC;
        } else {
            bArr2 = bArr;
            i3 = i11;
            c = c;
            iC = iC;
            async_contextVar = async_contextVarB;
            tlv_t403Var = tlv_t403Var2;
            if (tlv_t113Var2.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                this.x.f = tlv_t113Var2.get_uin();
                oicq.wlogin_sdk.request.t tVar13 = this.x;
                tVar13.a(tVar13.g, java.lang.Long.valueOf(tVar13.f));
            }
            i5 = tlv_t104Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
            if (i5 >= 0) {
                async_contextVar._t104 = tlv_t104Var;
                i5 = tlv_t174Var.get_tlv(bArr2, i3, (this.c - i3) - 1);
                if (i5 >= 0) {
                    async_contextVar._t174 = tlv_t174Var;
                    if (tlv_t178Var.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._devlock_info.CountryCode = new java.lang.String(tlv_t178Var.get_country_code());
                        async_contextVar._devlock_info.Mobile = new java.lang.String(tlv_t178Var.get_mobile());
                        async_contextVar._devlock_info.MbItemSmsCodeStatus = tlv_t178Var.get_smscode_status();
                        async_contextVar._devlock_info.AvailableMsgCount = tlv_t178Var.get_available_msg_cnt();
                        async_contextVar._devlock_info.TimeLimit = tlv_t178Var.get_time_limit();
                    }
                    oicq.wlogin_sdk.tlv_type.tlv_t196 tlv_t196Var = new oicq.wlogin_sdk.tlv_type.tlv_t196();
                    if (tlv_t196Var.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._devlock_info.BakCountryCode = tlv_t196Var.getCountryCode();
                        async_contextVar._devlock_info.BakMobile = tlv_t196Var.getBakMobile();
                        async_contextVar._devlock_info.BakMobileState = tlv_t196Var.getBakMobileState();
                    }
                    if (tlv_t179Var.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._devlock_info.UnionVerifyUrl = new java.lang.String(tlv_t179Var.get_verify_url());
                    }
                    if (tlv_t17dVar.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._devlock_info.MbGuideType = tlv_t17dVar.get_mb_guide_type();
                        async_contextVar._devlock_info.MbGuideMsg = new java.lang.String(tlv_t17dVar.get_mb_guide_msg());
                        async_contextVar._devlock_info.MbGuideInfoType = tlv_t17dVar.get_mb_guide_info_type();
                        async_contextVar._devlock_info.MbGuideInfo = new java.lang.String(tlv_t17dVar.get_mb_guide_info());
                    }
                    if (tlv_t17eVar.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._devlock_info.VerifyReason = new java.lang.String(tlv_t17eVar.get_data());
                    }
                    i4 = 1;
                    if (tlv_t402Var.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._t402 = tlv_t402Var;
                    } else {
                        async_contextVar._t402 = new oicq.wlogin_sdk.tlv_type.tlv_t402();
                    }
                    if (tlv_t403Var.get_tlv(bArr2, i3, (this.c - i3) - 1) >= 0) {
                        async_contextVar._t403 = tlv_t403Var;
                    } else {
                        async_contextVar._t403 = new oicq.wlogin_sdk.tlv_type.tlv_t403();
                    }
                    c(bArr2, i3, (this.c - i3) - i4);
                    iA = iC;
                }
            }
            iA = i5;
        }
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append("type:");
        sb4.append(iC);
        sb4.append(" ret:");
        sb4.append(iA > 0 ? "0x" + java.lang.Integer.toHexString(iA) : java.lang.Integer.valueOf(iA));
        oicq.wlogin_sdk.tools.util.LOGI(sb4.toString(), "" + this.x.f);
        if (iA != 0) {
            new oicq.wlogin_sdk.tlv_type.tlv_t508().get_tlv(bArr2, i3, (this.c - i3) - 1);
            if (oicq.wlogin_sdk.tlv_type.tlv_t508.doFetch) {
                oicq.wlogin_sdk.tools.ErrMsg errMsg2 = new oicq.wlogin_sdk.tools.ErrMsg();
                iB = new oicq.wlogin_sdk.request.i(this.x, this.t, this.u, errMsg2).b(iA);
                if (iB != -1000) {
                    a(errMsg2);
                }
            }
            if (iB != 10 || iB == 161 || iB == 162 || iB == 164 || iB == 165 || iB == 166 || iB == 154 || (iB >= 128 && iB <= 143)) {
                c2 = 2;
                iB = -1000;
            } else {
                c2 = 2;
            }
            if (c != c2 && c != 6 && c != 7) {
                a(c);
            }
            return iB;
        }
        a((oicq.wlogin_sdk.tools.ErrMsg) null);
        iB = iA;
        if (iB != 10) {
            c2 = 2;
            iB = -1000;
        } else {
            c2 = 2;
            iB = -1000;
        }
        if (c != c2) {
            a(c);
        }
        return iB;
    }

    public java.net.Socket d() {
        return this.x.aj;
    }

    /* JADX WARN: Code duplicated, block: B:172:0x05fb A[Catch: Exception -> 0x05fe, TRY_LEAVE, TryCatch #8 {Exception -> 0x05fe, blocks: (B:170:0x05f5, B:172:0x05fb), top: B:233:0x05f5 }] */
    /* JADX WARN: Code duplicated, block: B:233:0x05f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x02ec A[PHI: r4 r10 r21
  0x02ec: PHI (r4v14 boolean) = (r4v13 boolean), (r4v27 boolean) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]
  0x02ec: PHI (r10v4 java.lang.String) = (r10v3 java.lang.String), (r10v7 java.lang.String) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]
  0x02ec: PHI (r21v5 int) = (r21v4 int), (r21v17 int) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x02f2 A[PHI: r4 r10 r12 r21
  0x02f2: PHI (r4v17 boolean) = (r4v13 boolean), (r4v27 boolean) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]
  0x02f2: PHI (r10v5 java.lang.String) = (r10v3 java.lang.String), (r10v7 java.lang.String) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]
  0x02f2: PHI (r12v6 int) = (r12v5 int), (r6v1 int) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]
  0x02f2: PHI (r21v7 int) = (r21v4 int), (r21v17 int) binds: [B:75:0x02ea, B:63:0x026b] A[DONT_GENERATE, DONT_INLINE]] */
    public int e() throws java.io.IOException {
        int i;
        int i2;
        int iB;
        int i3;
        int i4;
        int i5;
        java.lang.String hostAddress;
        boolean zIs_wap_proxy_retry;
        java.lang.String str;
        int i6;
        java.net.URL url;
        java.io.InputStream inputStream;
        java.net.Socket socket;
        java.net.Socket socket2;
        int i7;
        java.lang.StringBuilder sb;
        int i8;
        int i9;
        java.net.Socket socket3;
        java.net.InetSocketAddress inetSocketAddress;
        java.net.Socket socket4;
        oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ...", "" + this.x.f);
        byte[] bArrC = c();
        boolean z = false;
        java.net.InetSocketAddress inetSocketAddress2 = null;
        java.net.Socket socketD = d();
        java.lang.String str2 = "";
        boolean z2 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z3 = false;
        int i13 = 0;
        java.lang.String str3 = "";
        long jCurrentTimeMillis = 0;
        while (true) {
            if (i11 >= 6) {
                i = i10;
                i2 = i12;
                iB = i13;
                i3 = 6;
                break;
            }
            if (i11 != 0) {
                oicq.wlogin_sdk.tools.util.chg_retry_type(oicq.wlogin_sdk.request.t.t);
            }
            boolean zIs_wap_retry = oicq.wlogin_sdk.tools.util.is_wap_retry(oicq.wlogin_sdk.request.t.t);
            this.q = inetSocketAddress2;
            if (i11 == 0 || this.t == 2066) {
                z2 = zIs_wap_retry;
            } else {
                z2 = zIs_wap_retry;
                a(i10, jCurrentTimeMillis, i12, i11, z2, z3);
            }
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                try {
                    try {
                        if (z2) {
                            oicq.wlogin_sdk.tools.util.LOGI("try http connect " + i11 + " ...", "" + this.x.f);
                            java.lang.String strA = a(i11, z2);
                            try {
                                zIs_wap_proxy_retry = oicq.wlogin_sdk.tools.util.is_wap_proxy_retry(oicq.wlogin_sdk.request.t.t);
                                if (zIs_wap_proxy_retry) {
                                    try {
                                        str = oicq.wlogin_sdk.tools.util.get_proxy_ip();
                                        i6 = oicq.wlogin_sdk.tools.util.get_proxy_port();
                                        if (str == null || str.length() <= 0 || i6 == -1) {
                                            try {
                                                java.lang.String str4 = "proxy_ip=" + str + ",proxy_port=" + i6 + ",set is_wap_proxy_retry=" + z;
                                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                                sb2.append("");
                                                i5 = i11;
                                                try {
                                                    sb2.append(this.x.f);
                                                    oicq.wlogin_sdk.tools.util.LOGI(str4, sb2.toString());
                                                    zIs_wap_proxy_retry = false;
                                                } catch (java.net.ConnectException unused) {
                                                    zIs_wap_proxy_retry = false;
                                                    z3 = zIs_wap_proxy_retry;
                                                    str3 = str3;
                                                    i11 = i5 + 1;
                                                    str2 = str2;
                                                    i10 = oicq.wlogin_sdk.tools.util.E_NO_NETWORK;
                                                    inetSocketAddress2 = null;
                                                } catch (java.lang.Exception unused2) {
                                                    hostAddress = str3;
                                                    zIs_wap_proxy_retry = false;
                                                    str3 = hostAddress;
                                                    if (-1026 != i10) {
                                                        z3 = zIs_wap_proxy_retry;
                                                        str3 = str3;
                                                        i10 = -1000;
                                                    } else {
                                                        z3 = zIs_wap_proxy_retry;
                                                        str3 = str3;
                                                        i10 = i10;
                                                    }
                                                    i11 = i5 + 1;
                                                    str2 = str2;
                                                    inetSocketAddress2 = null;
                                                }
                                            } catch (java.net.ConnectException unused3) {
                                                i5 = i11;
                                            } catch (java.lang.Exception unused4) {
                                                i5 = i11;
                                            }
                                        } else {
                                            i5 = i11;
                                        }
                                    } catch (java.net.ConnectException unused5) {
                                        i5 = i11;
                                    } catch (java.lang.Exception unused6) {
                                        i5 = i11;
                                        hostAddress = str3;
                                        str3 = hostAddress;
                                        if (-1026 != i10) {
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            i10 = -1000;
                                        } else {
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            i10 = i10;
                                        }
                                        i11 = i5 + 1;
                                        str2 = str2;
                                        inetSocketAddress2 = null;
                                    }
                                } else {
                                    i5 = i11;
                                    str = null;
                                    i6 = -1;
                                }
                                if (zIs_wap_proxy_retry) {
                                    try {
                                        try {
                                            url = new java.net.URL("http://" + str + ":" + i6 + "/cgi-bin/wlogin_proxy_login");
                                        } catch (java.lang.Exception unused7) {
                                            hostAddress = str3;
                                            str3 = hostAddress;
                                            if (-1026 != i10) {
                                                z3 = zIs_wap_proxy_retry;
                                                str3 = str3;
                                                i10 = -1000;
                                            } else {
                                                z3 = zIs_wap_proxy_retry;
                                                str3 = str3;
                                                i10 = i10;
                                            }
                                            i11 = i5 + 1;
                                            str2 = str2;
                                            inetSocketAddress2 = null;
                                        }
                                    } catch (java.net.ConnectException unused8) {
                                        z3 = zIs_wap_proxy_retry;
                                        str3 = str3;
                                        i11 = i5 + 1;
                                        str2 = str2;
                                        i10 = oicq.wlogin_sdk.tools.util.E_NO_NETWORK;
                                    }
                                } else {
                                    java.net.InetSocketAddress inetSocketAddressA = oicq.wlogin_sdk.request.a.a(strA, z ? 1 : 0, this.x.l);
                                    this.q = inetSocketAddressA;
                                    if (inetSocketAddressA != null) {
                                        hostAddress = inetSocketAddressA.getAddress().getHostAddress();
                                        if (str3.equals(hostAddress)) {
                                            throw new java.lang.Exception("repeated failed http ip " + str3);
                                        }
                                        try {
                                            this.q = null;
                                            str3 = hostAddress;
                                        } catch (java.net.ConnectException unused9) {
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = hostAddress;
                                            i11 = i5 + 1;
                                            str2 = str2;
                                            i10 = oicq.wlogin_sdk.tools.util.E_NO_NETWORK;
                                        } catch (java.lang.Exception unused10) {
                                            str3 = hostAddress;
                                            if (-1026 != i10) {
                                                z3 = zIs_wap_proxy_retry;
                                                str3 = str3;
                                                i10 = -1000;
                                            }
                                            i11 = i5 + 1;
                                            str2 = str2;
                                            inetSocketAddress2 = null;
                                        }
                                    } else {
                                        hostAddress = strA;
                                    }
                                    url = new java.net.URL("http://" + hostAddress + "/cgi-bin/wlogin_proxy_login");
                                }
                                oicq.wlogin_sdk.tools.util.LOGI("try http proxy=" + zIs_wap_proxy_retry + " connect to " + url + " host " + strA, "" + this.x.f);
                                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
                                httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                                if (zIs_wap_proxy_retry) {
                                    httpURLConnection.setRequestProperty("X-Online-Host", strA);
                                }
                                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                                httpURLConnection.setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
                                httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bArrC.length));
                                httpURLConnection.setConnectTimeout(this.x.l);
                                httpURLConnection.setReadTimeout(this.x.l);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                oicq.wlogin_sdk.tools.util.LOGI("http request connect ...", "" + this.x.f);
                                if (oicq.wlogin_sdk.request.j.a(httpURLConnection, this.x.l)) {
                                    oicq.wlogin_sdk.tools.util.LOGI("http request write ...", "" + this.x.f);
                                    java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                                    outputStream.write(bArrC, z ? 1 : 0, bArrC.length);
                                    outputStream.flush();
                                    int responseCode = httpURLConnection.getResponseCode();
                                    try {
                                        oicq.wlogin_sdk.tools.util.LOGI("http request response code=" + responseCode, "" + this.x.f);
                                        if (200 != responseCode) {
                                            i11 = i5 + 1;
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            str2 = str2;
                                            i10 = -1000;
                                        } else {
                                            inputStream = httpURLConnection.getInputStream();
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            socket = socketD;
                                            str2 = str2;
                                            i11 = i5;
                                        }
                                    } catch (java.lang.Exception unused11) {
                                        i10 = responseCode;
                                        hostAddress = str3;
                                        str3 = hostAddress;
                                        if (-1026 != i10) {
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            i10 = -1000;
                                        } else {
                                            z3 = zIs_wap_proxy_retry;
                                            str3 = str3;
                                            i10 = i10;
                                        }
                                        i11 = i5 + 1;
                                        str2 = str2;
                                    }
                                } else {
                                    oicq.wlogin_sdk.tools.util.LOGI("http request connect failed", "" + this.x.f);
                                    if (-1026 != i10) {
                                        z3 = zIs_wap_proxy_retry;
                                        str3 = str3;
                                        i10 = -1000;
                                    } else {
                                        z3 = zIs_wap_proxy_retry;
                                        str3 = str3;
                                        i10 = i10;
                                    }
                                    i11 = i5 + 1;
                                    str2 = str2;
                                }
                            } catch (java.net.ConnectException unused12) {
                                i5 = i11;
                                zIs_wap_proxy_retry = z3;
                            } catch (java.lang.Exception unused13) {
                                i5 = i11;
                                hostAddress = str3;
                                zIs_wap_proxy_retry = z3;
                            }
                            inetSocketAddress2 = null;
                        } else {
                            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                            sb3.append("try bin connect ");
                            i11 = i11;
                            sb3.append(i11);
                            sb3.append(" ...");
                            oicq.wlogin_sdk.tools.util.LOGI(sb3.toString(), "" + this.x.f);
                            if (socketD == null) {
                                java.lang.String strA2 = "";
                                if (this.q == null) {
                                    strA2 = a(i11, z2);
                                    oicq.wlogin_sdk.tools.util.LOGI("DNS for " + strA2 + " request ...", "" + this.x.f);
                                    try {
                                        int iC = c(z2);
                                        this.r = iC;
                                        this.q = oicq.wlogin_sdk.request.a.a(strA2, iC, this.x.l);
                                    } catch (java.lang.Exception unused14) {
                                    }
                                }
                                java.net.InetSocketAddress inetSocketAddress3 = this.q;
                                if (inetSocketAddress3 == null || inetSocketAddress3.getAddress() != null) {
                                    java.net.InetSocketAddress inetSocketAddress4 = this.q;
                                    if (inetSocketAddress4 != null) {
                                        str2 = str2;
                                        if (!str2.equals(inetSocketAddress4.getAddress().getHostAddress())) {
                                            java.lang.String hostAddress2 = this.q.getAddress().getHostAddress();
                                            oicq.wlogin_sdk.tools.util.LOGI("DNS for " + strA2 + "(" + this.q.toString() + ") request OK", "" + this.x.f);
                                            str2 = hostAddress2;
                                            i12 = 1;
                                        }
                                    } else {
                                        str2 = str2;
                                    }
                                    if (this.q == null) {
                                        oicq.wlogin_sdk.tools.util.LOGI("DNS for " + strA2 + " request failed", "" + this.x.f);
                                        i10 = oicq.wlogin_sdk.tools.util.E_RESOLVE_ADDR;
                                    } else {
                                        oicq.wlogin_sdk.tools.util.LOGI("repeated failed bin ip " + str2, "" + this.x.f);
                                        if (-1026 != i10) {
                                            i12 = 1;
                                            str2 = str2;
                                            i10 = -1000;
                                            i11++;
                                            this.q = null;
                                            a((java.net.Socket) null);
                                            inetSocketAddress2 = null;
                                            socketD = null;
                                            z = false;
                                        } else {
                                            i10 = i10;
                                        }
                                    }
                                    i12 = 1;
                                    i11++;
                                    this.q = null;
                                    a((java.net.Socket) null);
                                    inetSocketAddress2 = null;
                                    socketD = null;
                                    z = false;
                                } else {
                                    if (this.q.getAddress() == null) {
                                        oicq.wlogin_sdk.tools.util.LOGI("_server_ip get address failed", "" + this.x.f);
                                    }
                                    i11++;
                                    this.q = null;
                                    a((java.net.Socket) null);
                                    str3 = str3;
                                    z2 = z2;
                                    str2 = str2;
                                    i10 = oicq.wlogin_sdk.tools.util.E_RESOLVE_ADDR;
                                    inetSocketAddress2 = null;
                                    i12 = 1;
                                    socketD = null;
                                }
                            } else {
                                str2 = str2;
                            }
                            if (socketD == null) {
                                try {
                                    oicq.wlogin_sdk.tools.util.LOGI("tcp connect to " + this.q + " request ...", "" + this.x.f);
                                    socket4 = new java.net.Socket();
                                    a(socket4);
                                    socket4.connect(this.q, this.x.l);
                                    socket4.setSoTimeout(this.x.l);
                                    socket4.setReceiveBufferSize(this.s.length);
                                    oicq.wlogin_sdk.tools.util.LOGI("tcp connect to " + this.q + " OK", "" + this.x.f);
                                } catch (java.net.ConnectException unused15) {
                                    i11++;
                                    this.q = null;
                                    a((java.net.Socket) null);
                                    inetSocketAddress2 = null;
                                    socketD = null;
                                    i10 = oicq.wlogin_sdk.tools.util.E_NO_NETWORK;
                                    z = false;
                                } catch (java.lang.Throwable unused16) {
                                    if (-1026 != i10) {
                                        str2 = str2;
                                        str2 = str2;
                                        i10 = -1000;
                                    } else {
                                        i10 = i10;
                                    }
                                    i11++;
                                    this.q = null;
                                    a((java.net.Socket) null);
                                    inetSocketAddress2 = null;
                                    socketD = null;
                                    z = false;
                                }
                            } else {
                                socket4 = socketD;
                            }
                            oicq.wlogin_sdk.tools.util.LOGI("tcp request write ...", "" + this.x.f);
                            java.io.OutputStream outputStream2 = socket4.getOutputStream();
                            outputStream2.write(bArrC, z ? 1 : 0, bArrC.length);
                            outputStream2.flush();
                            socket = socket4;
                            inputStream = socket4.getInputStream();
                            str3 = str3;
                        }
                        if (i8 < 0) {
                            i11++;
                            if (z2) {
                                socketD = socket2;
                            } else {
                                socket2.close();
                                this.q = null;
                            }
                            i10 = -1000;
                            z = false;
                            inetSocketAddress2 = null;
                        } else {
                            iB = b(this.s);
                            try {
                                if (iB <= this.f + 1) {
                                    i11++;
                                    if (!z2) {
                                        socket2.close();
                                        inetSocketAddress = null;
                                        this.q = inetSocketAddress;
                                        i13 = iB;
                                    }
                                    i13 = iB;
                                    socketD = socket2;
                                    i10 = -1000;
                                    z = false;
                                    inetSocketAddress2 = null;
                                } else {
                                    if (iB < this.s.length) {
                                        int i14 = this.f + 1;
                                        int i15 = iB - i14;
                                        while (true) {
                                            if (i15 <= 0) {
                                                i9 = -1;
                                                break;
                                            }
                                            i8 = inputStream.read(this.s, i14, i15);
                                            i9 = -1;
                                            if (i8 == -1) {
                                                break;
                                            }
                                            i14 += i8;
                                            i15 -= i8;
                                        }
                                        if (i8 != i9) {
                                            z2 = z2;
                                            i2 = i12;
                                            i3 = 6;
                                            i = i8;
                                            break;
                                        }
                                        i11++;
                                        if (!z2) {
                                            socket2.close();
                                            socket3 = null;
                                            this.q = null;
                                            i13 = iB;
                                            a(socket3);
                                            socketD = null;
                                            i10 = -1000;
                                            z = false;
                                            inetSocketAddress2 = null;
                                        }
                                    } else {
                                        i11++;
                                        if (!z2) {
                                            socket2.close();
                                            inetSocketAddress = null;
                                            this.q = inetSocketAddress;
                                            i13 = iB;
                                        }
                                    }
                                    i13 = iB;
                                    socketD = socket2;
                                    i10 = -1000;
                                    z = false;
                                    inetSocketAddress2 = null;
                                }
                            } catch (java.lang.Throwable unused17) {
                                i7 = 1;
                                i11 += i7;
                                if (!z2) {
                                    try {
                                        if (socket2.isConnected()) {
                                            socket2.close();
                                        }
                                    } catch (java.lang.Exception unused18) {
                                    }
                                    this.q = null;
                                    a((java.net.Socket) null);
                                    i13 = iB;
                                    socketD = null;
                                    i10 = -1000;
                                    z = false;
                                    inetSocketAddress2 = null;
                                }
                                i13 = iB;
                                socketD = socket2;
                                i10 = -1000;
                                z = false;
                                inetSocketAddress2 = null;
                            }
                        }
                        a(socket3);
                    } catch (java.lang.Throwable unused19) {
                        iB = i13;
                        i7 = 1;
                        socket2 = null;
                        i11 += i7;
                        if (!z2) {
                            if (socket2.isConnected()) {
                                socket2.close();
                            }
                            this.q = null;
                            a((java.net.Socket) null);
                            i13 = iB;
                        }
                        i13 = iB;
                        socketD = socket2;
                        i10 = -1000;
                        z = false;
                        inetSocketAddress2 = null;
                    }
                    sb.append(this.x.f);
                    oicq.wlogin_sdk.tools.util.LOGI("recv data from server ...", sb.toString());
                    int i16 = 0;
                    i8 = 0;
                    while (i16 < this.f + 1 && (i8 = inputStream.read(this.s, i16, (this.f + 1) - i16)) >= 0) {
                        i16 += i8;
                    }
                    socket3 = null;
                } catch (java.lang.Throwable unused20) {
                    iB = i13;
                    i7 = 1;
                    i11 += i7;
                    if (!z2) {
                        if (socket2.isConnected()) {
                            socket2.close();
                        }
                        this.q = null;
                        a((java.net.Socket) null);
                        i13 = iB;
                        socketD = null;
                        i10 = -1000;
                        z = false;
                        inetSocketAddress2 = null;
                    }
                    i13 = iB;
                    socketD = socket2;
                    i10 = -1000;
                    z = false;
                    inetSocketAddress2 = null;
                }
                sb = new java.lang.StringBuilder();
                sb.append("");
                socket2 = socket;
            } catch (java.lang.Throwable unused21) {
                socket2 = socket;
            }
            socketD = null;
            i10 = -1000;
            z = false;
            inetSocketAddress2 = null;
        }
        if (i11 < i3) {
            i = 0;
        } else if (-1026 != i) {
            i = -1000;
        }
        if (i == 0) {
            b(this.s, iB);
        }
        if (i == 0 && this.t != 2066) {
            oicq.wlogin_sdk.report.report_t3 report_t3Var = new oicq.wlogin_sdk.report.report_t3();
            report_t3Var._cmd = this.t;
            report_t3Var._sub = this.u;
            report_t3Var._rst2 = i;
            report_t3Var._used = (int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            report_t3Var._try = i11;
            java.lang.String str5 = H;
            report_t3Var._host = str5;
            if (str5 == null) {
                report_t3Var._host = "";
            }
            java.net.InetSocketAddress inetSocketAddress5 = this.q;
            report_t3Var._ip = inetSocketAddress5 == null ? "" : inetSocketAddress5.getAddress().getHostAddress();
            report_t3Var._port = this.r;
            report_t3Var._conn = i2;
            report_t3Var._net = oicq.wlogin_sdk.request.t.D;
            report_t3Var._str = "";
            report_t3Var._slen = bArrC.length;
            report_t3Var._rlen = iB;
            if (z2) {
                i4 = z3 ? 2 : 1;
            } else {
                i4 = 0;
            }
            report_t3Var._wap = i4;
            oicq.wlogin_sdk.request.t.an.add_t3(report_t3Var);
        }
        oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ret=" + i, "" + this.x.f);
        return i;
    }

    public int f() {
        return oicq.wlogin_sdk.request.t.b(this.x.h)._last_flowid;
    }

    public void g() {
        this.z = true;
    }
}
