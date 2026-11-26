package cn.yunzhisheng.asr;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VAD {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static int f = 0;
    private static final int l = 0;
    private static final int m = 1;
    private static final int n = -1001;
    private double C;
    protected long i;
    private cn.yunzhisheng.asr.a p;
    private com.unisound.sdk.cs q;
    private java.io.ByteArrayOutputStream o = new java.io.ByteArrayOutputStream(oicq.wlogin_sdk.tools.util.MAX_CONTENT_SIZE);
    public java.util.List<byte[]> g = new java.util.LinkedList();
    private boolean r = false;
    private boolean s = false;
    public boolean h = false;
    public boolean j = true;
    public boolean k = false;
    private boolean t = false;
    private boolean u = false;
    private byte[] v = {99};
    private boolean w = false;
    private int x = 0;
    private java.util.ArrayList<byte[]> y = new java.util.ArrayList<>();
    private boolean z = false;
    private java.util.ArrayList<byte[]> A = new java.util.ArrayList<>();
    private boolean B = false;

    public VAD(cn.yunzhisheng.asr.a aVar, com.unisound.sdk.cs csVar) {
        this.i = 0L;
        this.p = aVar;
        this.q = csVar;
        this.i = create();
        if (this.i == 0) {
            com.unisound.common.y.a("jni VAD create fail!");
            return;
        }
        if (this.p.c.a()) {
            this.p.n(true);
            this.p.S();
            if (this.p.c != null) {
                this.p.c.a(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
        if (this.p.av()) {
            this.p.af();
        }
        this.p.l(false);
        a(this.p.n());
        init(this.i);
    }

    private double a(double d2) {
        return d2 / 32.0d;
    }

    private int a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i - 1) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            int i7 = i4 + 1;
            bArr2[i4] = b2;
            int i8 = i7 + 1;
            bArr2[i7] = b3;
            int i9 = i8 + 1;
            bArr2[i8] = b2;
            i4 = i9 + 1;
            bArr2[i9] = b3;
            i3 = i6;
        }
        return i4;
    }

    private java.lang.String b(int i, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("timeout", i);
            jSONObject.put("afterTimeoutVoice", str);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void b(int i) {
        com.unisound.sdk.cs csVar = this.q;
        if (csVar != null) {
            csVar.b(i);
        }
    }

    private void b(boolean z) {
        long j;
        int i;
        if (z != this.s && a()) {
            this.s = z;
            if (this.s) {
                j = this.i;
                i = 1;
            } else {
                j = this.i;
                i = 0;
            }
            setTime(j, -1001, i);
        }
    }

    private void c(int i) {
        a(i);
        if (this.p.b() && this.p.z()) {
            com.unisound.common.j.a(false, this.p.c());
        }
        com.unisound.sdk.cs csVar = this.q;
        if (csVar != null) {
            csVar.a(this);
            this.p.v(true);
        }
        if (i != 2) {
            com.unisound.common.y.c("VAD >>", "TimeOut");
        }
    }

    private void d(int i) {
        double d2 = this.C;
        double d3 = i;
        java.lang.Double.isNaN(d3);
        this.C = d2 + d3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void d(byte[] bArr) {
        this.g.add(bArr);
        int size = this.g.size() - 1;
        int length = 0;
        while (true) {
            if (size < 0) {
                size = 0;
                break;
            }
            length += this.g.get(size).length;
            if (length >= this.p.ad) {
                break;
            } else {
                size--;
            }
        }
        for (int i = 0; i < size; i++) {
            byte[] bArrRemove = this.g.remove(0);
            a(false, bArrRemove, 0, bArrRemove.length);
        }
    }

    private void f() {
        com.unisound.sdk.cs csVar = this.q;
        if (csVar != null) {
            csVar.n();
        }
    }

    private void g() {
        com.unisound.sdk.cs csVar = this.q;
        if (csVar != null) {
            csVar.o();
        }
    }

    private void h() {
        this.y.clear();
        this.z = false;
    }

    private void i() {
        this.A.clear();
        this.B = false;
    }

    private void j() {
        this.C = 0.0d;
    }

    private double k() {
        return this.C;
    }

    public int a(int i, java.lang.String str) {
        if (this.i == 0) {
            return -1;
        }
        if (str == null || str.length() == 0) {
            return 0;
        }
        return nativeSetOption(this.i, i, str);
    }

    public int a(cn.yunzhisheng.asr.b bVar) {
        if (bVar.c()) {
            return a(bVar.b, bVar.toString());
        }
        return 0;
    }

    public int a(byte[] bArr, int i) {
        if (a()) {
            return checkPitchOffset(this.i, bArr, i);
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x02ec A[Catch: all -> 0x041e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x000e, B:11:0x0014, B:13:0x001c, B:14:0x0025, B:16:0x0033, B:17:0x004f, B:19:0x0052, B:21:0x0056, B:23:0x005a, B:29:0x0063, B:31:0x0069, B:33:0x0073, B:35:0x007d, B:37:0x0087, B:45:0x00ef, B:47:0x00f5, B:49:0x00ff, B:51:0x0109, B:69:0x01eb, B:71:0x01f3, B:72:0x01fa, B:74:0x0210, B:76:0x0218, B:78:0x022b, B:79:0x022d, B:81:0x0231, B:83:0x0239, B:85:0x023d, B:88:0x0247, B:90:0x024f, B:92:0x0253, B:163:0x03ee, B:165:0x03f2, B:93:0x0260, B:127:0x0326, B:129:0x032a, B:131:0x0330, B:133:0x0338, B:135:0x0340, B:146:0x036b, B:148:0x0383, B:150:0x038b, B:151:0x038f, B:153:0x0397, B:155:0x039b, B:157:0x03a5, B:159:0x03ab, B:160:0x03ca, B:162:0x03d0, B:137:0x0348, B:138:0x034c, B:140:0x0352, B:142:0x0356, B:144:0x035e, B:145:0x0368, B:97:0x026a, B:99:0x0272, B:101:0x0276, B:103:0x027b, B:105:0x0283, B:107:0x028b, B:108:0x0294, B:102:0x0279, B:110:0x02b4, B:112:0x02d2, B:114:0x02da, B:116:0x02e2, B:117:0x02e4, B:119:0x02e8, B:121:0x02ef, B:123:0x02f7, B:125:0x02ff, B:126:0x0308, B:120:0x02ec, B:168:0x0410, B:52:0x011e, B:53:0x0133, B:55:0x013d, B:56:0x0152, B:57:0x0167, B:59:0x0171, B:61:0x017b, B:63:0x01aa, B:62:0x0193, B:64:0x01ae, B:66:0x01b8, B:67:0x01d0, B:38:0x0099, B:39:0x00ab, B:40:0x00b0, B:41:0x00c3, B:43:0x00cb, B:44:0x00de), top: B:175:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(byte[] bArr, int i, int i2) {
        byte[][] bArrA;
        com.unisound.common.s sVar;
        int length;
        byte[] bArr2;
        int iA;
        byte[] bArr3;
        byte[] bArr4;
        int length2;
        byte[] bArrCopyOfRange;
        int length3;
        byte[] bArrCopyOfRange2;
        int iB;
        if (bArr.length == 1 && (bArr[0] == 99 || bArr[0] == 100)) {
            return 0;
        }
        if (this.p.b()) {
            com.unisound.common.j.a(bArr, this.p.c());
        }
        this.p.c.b(bArr);
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("VAD::write size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]));
        }
        if (bArr.length == 1 && (bArr[0] == 100 || bArr[0] == 99)) {
            a(true, bArr, 0, i2);
            return 0;
        }
        if (i2 <= 0) {
            return 0;
        }
        if (this.p.c == null || !this.p.c.a()) {
            if (this.p.av()) {
                sVar = this.p.c;
                bArrA = sVar.a(bArr);
            } else {
                bArrA = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 2, bArr.length);
                bArrA[1] = bArr;
                bArrA[0] = bArr;
            }
        } else if (this.p.c.s() && this.p.c.t()) {
            bArrA = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 2, bArr.length);
            bArrA[1] = bArr;
            bArrA[0] = bArr;
        } else {
            sVar = this.p.c;
            bArrA = sVar.a(bArr);
        }
        if (this.p.ag) {
            if (this.p.c.i() == 0) {
                if (this.p.c.o()) {
                    length = bArrA[1].length * 2;
                    bArr2 = new byte[length];
                    iA = a(bArrA[0], bArrA[0].length, bArr2, length);
                    bArr3 = new byte[length];
                    bArr4 = bArrA[0];
                    length2 = bArrA[0].length;
                } else {
                    length = bArrA[1].length * 2;
                    bArr2 = new byte[length];
                    iA = a(bArrA[1], bArrA[1].length, bArr2, length);
                    bArr3 = new byte[length];
                    bArr4 = bArrA[0];
                    length2 = bArrA[0].length;
                }
            } else if (this.p.c.o()) {
                length = bArrA[0].length * 2;
                bArr2 = new byte[length];
                iA = a(bArrA[1], bArrA[1].length, bArr2, length);
                bArr3 = new byte[length];
                bArr4 = bArrA[1];
                length2 = bArrA[1].length;
            } else {
                length = bArrA[0].length * 2;
                bArr2 = new byte[length];
                iA = a(bArrA[0], bArrA[0].length, bArr2, length);
                bArr3 = new byte[length];
                bArr4 = bArrA[1];
                length2 = bArrA[1].length;
            }
            a(bArr4, length2, bArr3, length);
            bArrCopyOfRange = bArr2;
            length3 = iA;
            bArrCopyOfRange2 = bArr3;
        } else if (this.p.c.i() == 0) {
            if (this.p.c.o()) {
                bArrCopyOfRange = java.util.Arrays.copyOfRange(bArrA[0], 0, bArrA[0].length);
                bArrCopyOfRange2 = java.util.Arrays.copyOfRange(bArrA[0], 0, bArrA[0].length);
                length3 = bArrCopyOfRange.length;
            } else {
                bArrCopyOfRange = java.util.Arrays.copyOfRange(bArrA[1], 0, bArrA[1].length);
                bArrCopyOfRange2 = java.util.Arrays.copyOfRange(bArrA[0], 0, bArrA[0].length);
                length3 = bArrCopyOfRange.length;
            }
        } else if (this.p.c.o()) {
            bArrCopyOfRange = java.util.Arrays.copyOfRange(bArrA[1], 0, bArrA[1].length);
            bArrCopyOfRange2 = java.util.Arrays.copyOfRange(bArrA[1], 0, bArrA[1].length);
            length3 = bArrCopyOfRange.length;
        } else {
            bArrCopyOfRange = java.util.Arrays.copyOfRange(bArrA[0], 0, bArrA[0].length);
            bArrCopyOfRange2 = java.util.Arrays.copyOfRange(bArrA[1], 0, bArrA[1].length);
            length3 = bArrCopyOfRange.length;
        }
        if (!this.p.D()) {
            this.p.e(bArrCopyOfRange2.length);
        }
        this.p.c.c(bArrCopyOfRange2);
        this.p.c.d(bArrCopyOfRange);
        if (this.p.A() && this.p.B()) {
            this.x += bArr.length;
            if (this.x >= this.p.aj()) {
                this.w = true;
            }
        }
        if (this.j && (!this.p.A() || this.w || !this.p.B())) {
            if (!this.p.m() || this.r) {
                iB = b(bArrCopyOfRange, length3);
                if (iB != 0) {
                    if (iB == 1) {
                        if (!this.p.A() || this.u) {
                            this.B = true;
                        } else {
                            this.z = true;
                        }
                        if (this.p.b() && this.p.z()) {
                            com.unisound.common.j.b(false, this.p.c());
                        }
                        com.unisound.common.y.c("VAD >>", "ASR_VAD_BACK_END ", "param = ", java.lang.Boolean.valueOf(this.u));
                        g();
                    } else if (iB == 2) {
                        this.p.c(b(0, ""));
                        c(2);
                        com.unisound.common.y.c("VAD >>", "ASR_VAD_MAX_SIL1");
                    } else if (iB == 3) {
                        if (this.p.A()) {
                            if (this.p.B()) {
                                this.u = true;
                            }
                            if (this.u) {
                                i();
                            } else {
                                h();
                            }
                        } else {
                            i();
                        }
                        if (this.p.b() && this.p.z()) {
                            com.unisound.common.j.a(true, this.p.c());
                        }
                        this.h = true;
                        com.unisound.common.y.c("VAD >>", "ASR_VAD_FRONT_END ", "param = ", java.lang.Boolean.valueOf(this.u));
                        f();
                    }
                }
                if (!this.h && this.p.Y && this.p.at()) {
                    if (!this.p.A() || !this.p.B()) {
                        d(bArrCopyOfRange2);
                    }
                } else if (this.p.Y && !this.t && this.p.at()) {
                    this.g.add(bArrCopyOfRange2);
                    this.t = this.h;
                } else {
                    a(true, bArrCopyOfRange2, 0, length3);
                }
                com.unisound.common.y.f("VAD done        1");
                b(c());
                if (this.p.A() && this.p.B()) {
                    d(bArr.length);
                }
                if (!this.p.A() || this.u || this.p.c.a()) {
                    if (c(bArrCopyOfRange)) {
                        this.p.c(b(1, java.lang.String.valueOf(a(k()))));
                        c(iB);
                        j();
                        i();
                    }
                } else if (b(bArrCopyOfRange)) {
                    this.p.c(b(2, java.lang.String.valueOf(a(k()))));
                    c(iB);
                    j();
                    h();
                }
            } else {
                a(bArrCopyOfRange2);
                b(c());
                iB = 0;
            }
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("AF_VAD::read size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]));
            }
            return iB;
        }
        a(true, bArrCopyOfRange2, 0, bArrCopyOfRange2.length);
        b(c(bArrCopyOfRange2, bArrCopyOfRange2.length));
        return 0;
    }

    public synchronized void a(int i) {
        this.h = false;
        this.r = false;
        this.t = false;
        this.g.clear();
        this.o.reset();
        if (this.p.A()) {
            this.u = false;
        }
        if (a()) {
            if (i == 2) {
                reset(this.i);
            }
        }
    }

    public void a(int i, int i2) {
        if (a()) {
            setTime(this.i, i / 10, i2 / 10);
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void a(boolean z, byte[] bArr, int i, int i2) {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("VAD::onVadData size =", java.lang.Integer.valueOf(bArr.length), " first byte ", java.lang.Byte.valueOf(bArr[0]), "enabled = ", java.lang.Boolean.valueOf(z));
        }
        com.unisound.sdk.cs csVar = this.q;
        if (z && this.p.d() != null && !this.p.d().equals("") && (bArr.length != 1 || (bArr[0] != 100 && bArr[0] != 99))) {
            com.unisound.common.j.a(bArr, this.p.d());
        }
        if (csVar != null) {
            csVar.b(z, bArr, i, i2);
        }
    }

    protected synchronized void a(byte[] bArr) {
        this.o.write(bArr, 0, bArr.length);
        if (this.o.size() >= this.p.ae) {
            byte[] byteArray = this.o.toByteArray();
            this.o.reset();
            int iCheckPitchOffset = checkPitchOffset(this.i, byteArray, byteArray.length);
            if (iCheckPitchOffset > 0) {
                byte[] bArr2 = new byte[iCheckPitchOffset];
                java.lang.System.arraycopy(byteArray, 0, bArr2, 0, iCheckPitchOffset);
                a(false, bArr2, 0, bArr2.length);
                this.o.write(byteArray, iCheckPitchOffset, byteArray.length - iCheckPitchOffset);
                byteArray = this.o.toByteArray();
                this.o.reset();
            }
            f = iCheckPitchOffset;
            if (byteArray.length > 0) {
                a(true, byteArray, 0, byteArray.length);
                b(byteArray, byteArray.length);
            }
            this.r = true;
            this.h = true;
        }
    }

    public boolean a() {
        return this.i != 0;
    }

    public int b(byte[] bArr, int i) {
        long j = this.i;
        if (j == 0) {
            return 0;
        }
        return isVADTimeout(j, bArr, i);
    }

    public void b() {
        com.unisound.common.y.b("frontSil = ", java.lang.Integer.valueOf(this.p.ab), " backSil= ", java.lang.Integer.valueOf(this.p.ac));
        a(this.p.ab, this.p.ac);
        if (this.p.h()) {
            com.unisound.common.y.b("mParams.isFarFeildEnabled() = ", java.lang.Boolean.valueOf(this.p.h()));
            b(this.p.h());
        }
        if (this.p.y.f4a != null && !this.p.y.f4a.equals("")) {
            com.unisound.common.y.b("mParams.MINBACKENG = ", this.p.y.f4a);
            a(this.p.y);
        }
        if (this.p.z.f4a != null && !this.p.z.f4a.equals("")) {
            com.unisound.common.y.b("mParams.MINBACKENGH = ", this.p.z.f4a);
            a(this.p.z);
        }
        if (this.p.A.f4a != null && !this.p.A.f4a.equals("")) {
            com.unisound.common.y.b("mParams.PITCHTH = ", this.p.A.f4a);
            a(this.p.A);
        }
        if (this.p.B.f4a != null && !this.p.B.f4a.equals("")) {
            com.unisound.common.y.b("mParams.PITCHSTNUMTH = ", this.p.B.f4a);
            a(this.p.B);
        }
        if (this.p.C.f4a != null && !this.p.C.f4a.equals("")) {
            com.unisound.common.y.b("mParams.PITCHENDNUMTH = ", this.p.C.f4a);
            a(this.p.C);
        }
        if (this.p.D.f4a != null && !this.p.D.f4a.equals("")) {
            com.unisound.common.y.b("mParams.LOWHIGHTH = ", this.p.D.f4a);
            a(this.p.D);
        }
        if (this.p.E.f4a != null && !this.p.E.f4a.equals("")) {
            com.unisound.common.y.b("mParams.MINSIGLEN = ", this.p.E.f4a);
            a(this.p.E);
        }
        if (this.p.F.f4a != null && !this.p.F.f4a.equals("")) {
            if (!this.p.F.f4a.equals((this.p.ac / 10) + "")) {
                com.unisound.common.y.b("mParams.MAXSILLEN = ", this.p.F.f4a);
                a(this.p.F);
            }
        }
        if (this.p.G.f4a != null && !this.p.G.f4a.equals("")) {
            com.unisound.common.y.b("mParams.SINGLEMAX = ", this.p.G.f4a);
            a(this.p.G);
        }
        if (this.p.H.f4a != null && !this.p.H.f4a.equals("")) {
            com.unisound.common.y.b("mParams.NOISE2YTH = ", this.p.H.f4a);
            a(this.p.H);
        }
        if (this.p.I.f4a != null && !this.p.I.f4a.equals("")) {
            com.unisound.common.y.b("mParams.NOISE2YTHVOWEL = ", this.p.I.f4a);
            a(this.p.I);
        }
        if (this.p.J.f4a != null && !this.p.J.f4a.equals("")) {
            com.unisound.common.y.b("mParams.VOICEPROBTH = ", this.p.J.f4a);
            a(this.p.J);
        }
        if (this.p.K.f4a != null && !this.p.K.f4a.equals("")) {
            com.unisound.common.y.b("mParams.USEPEAK = ", this.p.K.f4a);
            a(this.p.K);
        }
        if (this.p.L.f4a != null && !this.p.L.f4a.equals("")) {
            com.unisound.common.y.b("mParams.NOISE2YST = ", this.p.L.f4a);
            a(this.p.L);
        }
        if (this.p.M.f4a != null && !this.p.M.f4a.equals("")) {
            com.unisound.common.y.b("mParams.PITCHLASTTH = ", this.p.M.f4a);
            a(this.p.M);
        }
        if (this.p.N.f4a != null && !this.p.N.f4a.equals("")) {
            com.unisound.common.y.b("mParams.DETECTMUSIC = ", this.p.N.f4a);
            a(this.p.N);
        }
        if (this.p.O.f4a != null && !this.p.O.f4a.equals("")) {
            com.unisound.common.y.b("mParams.MUSICTH = ", this.p.O.f4a);
            a(this.p.O);
        }
        j();
    }

    protected boolean b(byte[] bArr) {
        if (this.z) {
            this.y.add(bArr);
            int iG = this.p.G();
            int length = 0;
            for (int size = this.y.size() - 1; size >= 0; size--) {
                length += this.y.get(size).length;
                if (length >= iG) {
                    return true;
                }
            }
        }
        return false;
    }

    public int c() {
        if (a()) {
            return getVolume(this.i);
        }
        return 0;
    }

    protected int c(byte[] bArr, int i) {
        float fAbs = 0.0f;
        for (int i2 = 0; i2 < i; i2 += 2) {
            int i3 = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8);
            if (i3 >= 32768) {
                i3 = android.support.v4.internal.view.SupportMenu.USER_MASK - i3;
            }
            fAbs += java.lang.Math.abs(i3);
        }
        int iLog10 = (int) (((java.lang.Math.log10(((fAbs * 2.0f) / i) + 1.0f) * 10.0d) - 20.0d) * 5.0d);
        if (iLog10 < 0) {
            iLog10 = 0;
        }
        if (iLog10 > 100) {
            return 100;
        }
        return iLog10;
    }

    protected boolean c(byte[] bArr) {
        if (this.B) {
            this.A.add(bArr);
            int iH = this.p.H();
            int length = 0;
            for (int size = this.A.size() - 1; size >= 0; size--) {
                length += this.A.get(size).length;
                if (length >= iH) {
                    return true;
                }
            }
        }
        return false;
    }

    protected native int checkPitchOffset(long j, byte[] bArr, int i);

    protected native long create();

    public synchronized void d() {
        if (a()) {
            try {
                this.o.close();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            destory(this.i);
            this.i = 0L;
        }
    }

    protected native void destory(long j);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void e() {
        if (this.o.size() > 0) {
            a(this.h, this.o.toByteArray(), 0, this.o.size());
            this.o.reset();
        }
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            byte[] bArrRemove = this.g.remove(0);
            a(this.h, bArrRemove, 0, bArrRemove.length);
        }
        b(0);
    }

    protected native int getVolume(long j);

    protected native void init(long j);

    protected native int isVADTimeout(long j, byte[] bArr, int i);

    protected native int nativeSetOption(long j, int i, java.lang.String str);

    protected native void reset(long j);

    protected native void setTime(long j, int i, int i2);
}
