package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class t {
    public static byte[] ai;
    public static java.lang.String at;
    public int aq;
    public oicq.wlogin_sdk.request.WFastLoginInfo j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.security.SecureRandom f1687a = m();
    static java.lang.Boolean e = java.lang.Boolean.FALSE;
    public static android.content.Context t = null;
    public static int u = 2052;
    public static java.lang.String v = "";
    static int w = 0;
    static int x = 1;
    static int y = 0;
    static int z = 0;
    public static byte[] A = new byte[0];
    static byte[] B = new byte[0];
    public static byte[] C = new byte[0];
    public static int D = 0;
    public static byte[] E = new byte[0];
    public static byte[] F = new byte[0];
    public static byte[] G = new byte[0];
    public static byte[] H = new byte[0];
    public static byte[] I = new byte[0];
    public static byte[] J = new byte[0];
    public static byte[] K = "android".getBytes();
    static byte[] L = new byte[0];
    static byte[] M = new byte[0];
    static byte[] N = new byte[0];
    static byte[] O = new byte[0];
    static byte[] P = new byte[0];
    static byte[] Q = new byte[0];
    static byte[] R = new byte[0];
    static byte[] S = new byte[0];
    static int T = 0;
    static int U = 0;
    static int V = 0;
    static int W = 0;
    static int X = 0;
    public static int Y = 0;
    public static int Z = 0;
    static byte[] aa = new byte[0];
    static long ab = 0;
    public static long ac = 0;
    static byte[] ad = new byte[4];
    static int ae = 0;
    static int af = 0;
    public static boolean ag = false;
    public static int ah = 1;
    public static oicq.wlogin_sdk.request.d al = null;
    protected static java.lang.String am = "";
    public static oicq.wlogin_sdk.report.Reporter an = new oicq.wlogin_sdk.report.Reporter();
    public static long ao = 0;
    public static java.util.TreeMap ap = new java.util.TreeMap();
    private static java.lang.Object av = new java.lang.Object();
    public static boolean ar = false;
    public static boolean as = true;
    public static int au = 0;
    public byte[] b = null;
    public byte[] c = new byte[16];
    public oicq.wlogin_sdk.tlv_type.tlv_t150 d = null;
    public long f = 0;
    public java.lang.String g = "";
    public long h = 0;
    public int i = 0;
    public int k = 0;
    public int l = com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING;
    public int m = 0;
    public byte[] n = new byte[16];
    public byte[] o = new byte[16];
    public byte[] p = new byte[16];
    public byte[] q = new byte[0];
    public byte[] r = new byte[0];
    public int s = 0;
    java.net.Socket aj = null;
    java.net.Socket ak = null;

    public t(android.content.Context context) {
    }

    public static synchronized long a() {
        long j;
        if (ao > 200) {
            ao = 0L;
        }
        j = ao + 1;
        ao = j;
        return j;
    }

    public static byte[] a(android.content.Context context) {
        return null;
    }

    public static oicq.wlogin_sdk.request.async_context b(long j) {
        oicq.wlogin_sdk.request.async_context async_contextVar;
        synchronized (av) {
            async_contextVar = (oicq.wlogin_sdk.request.async_context) ap.get(java.lang.Long.valueOf(j));
            if (async_contextVar == null) {
                try {
                    oicq.wlogin_sdk.request.async_context async_contextVar2 = new oicq.wlogin_sdk.request.async_context();
                    try {
                        ap.put(java.lang.Long.valueOf(j), async_contextVar2);
                        async_contextVar = async_contextVar2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        async_contextVar = async_contextVar2;
                        oicq.wlogin_sdk.tools.util.printException(e, "");
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                }
            }
        }
        return async_contextVar;
    }

    public static void b() {
        java.lang.String str = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
        if (str.compareTo(v) != 0) {
            v = str;
            new oicq.wlogin_sdk.request.h(t).start();
        }
    }

    public static void c() {
        byte[] mD5Byte = oicq.wlogin_sdk.tools.util.get_mac_addr(t);
        if (mD5Byte != null && mD5Byte.length > 0) {
            mD5Byte = oicq.wlogin_sdk.tools.MD5.toMD5Byte(mD5Byte);
        }
        byte[] mD5Byte2 = oicq.wlogin_sdk.tools.util.get_imei_id(t);
        if (mD5Byte2 != null && mD5Byte2.length > 0) {
            mD5Byte2 = oicq.wlogin_sdk.tools.MD5.toMD5Byte(mD5Byte2);
        }
        byte[] bArrGenerateGuid = oicq.wlogin_sdk.tools.util.generateGuid(t);
        if (bArrGenerateGuid != null && bArrGenerateGuid.length > 0) {
            bArrGenerateGuid = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArrGenerateGuid);
        }
        if (oicq.wlogin_sdk.tools.util.get_last_flag(t) != 0) {
            byte[] bArr = oicq.wlogin_sdk.tools.util.get_last_mac(t);
            byte[] bArr2 = oicq.wlogin_sdk.tools.util.get_last_imei(t);
            byte[] bArr3 = oicq.wlogin_sdk.tools.util.get_last_guid(t);
            if (!java.util.Arrays.equals(mD5Byte, bArr)) {
                X |= 1;
            }
            if (!java.util.Arrays.equals(mD5Byte2, bArr2)) {
                X |= 2;
            }
            if (!java.util.Arrays.equals(bArrGenerateGuid, bArr3)) {
                X |= 4;
            }
        }
        oicq.wlogin_sdk.tools.util.save_cur_flag(t, 1);
        oicq.wlogin_sdk.tools.util.save_cur_mac(t, mD5Byte);
        oicq.wlogin_sdk.tools.util.save_cur_imei(t, mD5Byte2);
        oicq.wlogin_sdk.tools.util.save_cur_guid(t, bArrGenerateGuid);
    }

    public static void c(long j) {
        synchronized (av) {
            try {
                ap.remove(java.lang.Long.valueOf(j));
            } catch (java.lang.Exception e2) {
                oicq.wlogin_sdk.tools.util.printException(e2, "");
            }
        }
    }

    public static void d() throws java.lang.Throwable {
        oicq.wlogin_sdk.tools.util.LOGI("init start", "");
        int i = oicq.wlogin_sdk.tools.util.get_saved_network_type(t);
        Y = 0;
        a(t);
        byte[] guidFromFile = oicq.wlogin_sdk.tools.util.getGuidFromFile(t);
        oicq.wlogin_sdk.tools.util.LOGI("get saved guid " + oicq.wlogin_sdk.tools.util.buf_to_string(guidFromFile), "");
        byte[] bArrGenerateGuid = oicq.wlogin_sdk.tools.util.generateGuid(t);
        oicq.wlogin_sdk.tools.util.LOGI("get current guid " + oicq.wlogin_sdk.tools.util.buf_to_string(bArrGenerateGuid), "");
        if (guidFromFile == null || guidFromFile.length <= 0) {
            if (bArrGenerateGuid == null || bArrGenerateGuid.length <= 0) {
                guidFromFile = new java.lang.String("%4;7t>;28<fc.5*6").getBytes();
                U = 0;
                W = 20;
            } else {
                U = 1;
                W = 17;
                guidFromFile = bArrGenerateGuid;
            }
            oicq.wlogin_sdk.tools.util.saveGuidToFile(t, guidFromFile);
            V = 0;
            T = 1;
        } else {
            if (bArrGenerateGuid == null || bArrGenerateGuid.length <= 0) {
                bArrGenerateGuid = new java.lang.String("%4;7t>;28<fc.5*6").getBytes();
            }
            if (java.util.Arrays.equals(bArrGenerateGuid, guidFromFile)) {
                V = 0;
            } else {
                V = 1;
            }
            U = 1;
            T = 0;
            W = 1;
        }
        c();
        int i2 = Y | ((W << 24) & (-16777216));
        Y = i2;
        Y = i2 | ((X << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        A = (byte[]) guidFromFile.clone();
        B = (byte[]) guidFromFile.clone();
        oicq.wlogin_sdk.tools.util.LOGI("guid src " + W, "");
        byte[] bArr = oicq.wlogin_sdk.tools.util.get_imei_id(t);
        M = bArr;
        if (bArr != null && bArr.length > 0) {
            M = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr);
        }
        ae = android.os.Build.VERSION.SDK_INT;
        byte[] bArr2 = oicq.wlogin_sdk.tools.util.get_mac_addr(t);
        N = bArr2;
        if (bArr2 != null && bArr2.length > 0) {
            N = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr2);
        }
        byte[] bArr3 = oicq.wlogin_sdk.tools.util.get_bssid_addr(t);
        R = bArr3;
        if (bArr3 != null && bArr3.length > 0) {
            R = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr3);
        }
        S = oicq.wlogin_sdk.tools.util.get_ssid_addr(t);
        byte[] bArr4 = oicq.wlogin_sdk.tools.util.get_android_id(t);
        O = bArr4;
        if (bArr4 != null && bArr4.length > 0) {
            O = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr4);
        }
        byte[] _imsi = oicq.wlogin_sdk.tools.util.get_IMSI(t);
        L = _imsi;
        if (_imsi != null && _imsi.length > 0) {
            L = oicq.wlogin_sdk.tools.MD5.toMD5Byte(_imsi);
        }
        C = oicq.wlogin_sdk.tools.util.get_sim_operator_name(t);
        int i3 = oicq.wlogin_sdk.tools.util.get_network_type(t);
        D = i3;
        if (i != i3) {
            oicq.wlogin_sdk.tools.util.set_net_retry_type(t, 0);
            oicq.wlogin_sdk.tools.util.save_network_type(t, D);
        }
        F = oicq.wlogin_sdk.tools.util.get_apn_string(t).getBytes();
        aa = oicq.wlogin_sdk.tools.util.get_ksid(t);
        E = oicq.wlogin_sdk.tools.util.get_apk_id(t);
        G = oicq.wlogin_sdk.tools.util.get_apk_v(t, new java.lang.String(E));
        android.content.Context context = t;
        H = oicq.wlogin_sdk.tools.util.getPkgSigFromApkName(context, context.getPackageName());
        Q = oicq.wlogin_sdk.tools.util.getAppName(t);
        java.lang.String strSubstring = android.os.Build.VERSION.RELEASE;
        if (strSubstring == null) {
            strSubstring = "";
        }
        if (16 < strSubstring.length()) {
            strSubstring = strSubstring.substring(0, 16);
        }
        J = strSubstring.getBytes();
        java.lang.String str = android.os.Build.MODEL;
        I = str == null ? new byte[0] : str.getBytes();
        java.lang.String str2 = android.os.Build.BRAND;
        P = str2 == null ? new byte[0] : str2.getBytes();
        Z = oicq.wlogin_sdk.tools.util.isFileExist("/system/bin/su") || oicq.wlogin_sdk.tools.util.isFileExist("/system/xbin/su") || oicq.wlogin_sdk.tools.util.isFileExist("/sbin/su") ? 1 : 0;
        al = new oicq.wlogin_sdk.request.d(t);
        oicq.wlogin_sdk.report.Reporter reporter = oicq.wlogin_sdk.report.report_t.read_fromfile(t);
        an = reporter;
        if (reporter == null) {
            an = new oicq.wlogin_sdk.report.Reporter();
        }
        oicq.wlogin_sdk.tools.util.LOGI("init done", "");
    }

    public static long f() {
        return java.lang.System.currentTimeMillis() / 1000;
    }

    public static long g() {
        return (java.lang.System.currentTimeMillis() / 1000) + ac;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static java.lang.String l() {
        java.lang.String str = am;
        if (str != null && str.length() > 0) {
            return am;
        }
        try {
            int iMyPid = android.os.Process.myPid();
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) t.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    java.lang.String str2 = runningAppProcessInfo.processName;
                    am = str2;
                    return str2;
                }
            }
            return "";
        } catch (java.lang.Throwable th) {
            oicq.wlogin_sdk.tools.util.printThrowable(th, "");
            return "";
        }
    }

    private static java.security.SecureRandom m() {
        try {
            return new java.security.SecureRandom();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public synchronized int a(long j, long j2, long j3, long j4, byte[] bArr, byte[] bArr2) {
        return al.a(j, j2, j3, j4, bArr, bArr2);
    }

    public synchronized int a(long j, long j2, byte[][] bArr, long j3, long j4, long j5, long j6, long j7, oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[][] bArr14, long[] jArr, int i) {
        oicq.wlogin_sdk.request.d dVar;
        dVar = al;
        dVar.e = this.aq;
        return dVar.a(j, j2, bArr, j3, j4, j5, j6, j7, wloginSimpleInfo, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, jArr, i);
    }

    public oicq.wlogin_sdk.request.t a(long j) {
        oicq.wlogin_sdk.request.t tVar = new oicq.wlogin_sdk.request.t(null);
        tVar.k = this.k;
        tVar.l = this.l;
        byte[] bArr = this.c;
        if (bArr != null) {
            tVar.c = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this.n;
        if (bArr2 != null && this.p != null) {
            tVar.n = (byte[]) bArr2.clone();
            tVar.p = (byte[]) this.p.clone();
        }
        if (j <= 0) {
            j = a();
        }
        tVar.h = j;
        return tVar;
    }

    public synchronized oicq.wlogin_sdk.sharemem.WloginSigInfo a(long j, long j2) {
        oicq.wlogin_sdk.tools.util.LOGI("get_siginfo appid=" + j2, j + "");
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoD = al.d(j, j2);
        return wloginSigInfoD != null ? wloginSigInfoD : wloginSigInfoD;
    }

    public synchronized void a(long j, long j2, byte[] bArr) {
        al.a(j, j2, bArr);
    }

    public synchronized void a(java.lang.String str) {
        al.a(str);
    }

    public synchronized void a(java.lang.String str, java.lang.Long l) {
        al.a(str, l, true);
    }

    public synchronized void a(java.lang.String str, java.lang.Long l, boolean z2) {
        al.a(str, l, z2);
    }

    public void a(byte[] bArr, byte[] bArr2) {
        long jBuf_to_int32 = (((long) oicq.wlogin_sdk.tools.util.buf_to_int32(bArr, 0)) & 4294967295L) - (java.lang.System.currentTimeMillis() / 1000);
        ab = jBuf_to_int32;
        ac = jBuf_to_int32;
        ad = bArr2;
    }

    public synchronized int b(long j, long j2) {
        return al.a(j, j2);
    }

    public synchronized long b(java.lang.String str) {
        oicq.wlogin_sdk.request.UinInfo uinInfoA = al.a(str, true);
        if (uinInfoA == null || uinInfoA._uin.longValue() == 0) {
            return 0L;
        }
        return uinInfoA._uin.longValue();
    }

    public void b(android.content.Context context) {
        t = context;
        byte[] bArr = oicq.wlogin_sdk.tools.util.get_rand_16byte(f1687a);
        java.lang.System.arraycopy(bArr, 0, this.c, 0, bArr.length);
    }

    public synchronized oicq.wlogin_sdk.request.UinInfo c(java.lang.String str) {
        return al.a(str, false);
    }

    public synchronized void c(long j, long j2) {
        al.b(j, j2);
    }

    public synchronized oicq.wlogin_sdk.sharemem.WloginSimpleInfo d(long j) {
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfoB = al.b(j);
        return wloginSimpleInfoB != null ? wloginSimpleInfoB : wloginSimpleInfoB;
    }

    public void d(long j, long j2) {
        al.c(j, j2);
    }

    public synchronized void d(java.lang.String str) {
        al.b(str);
    }

    public synchronized java.lang.String e(long j) {
        return al.b(java.lang.Long.valueOf(j));
    }

    public synchronized void e(long j, long j2) {
        al.a(java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2));
    }

    public boolean e() {
        return this.k != 0;
    }

    public void h() {
        oicq.wlogin_sdk.tools.util.LOGD("close_connect", "close_connect");
        java.net.Socket socket = this.aj;
        if (socket != null) {
            try {
                oicq.wlogin_sdk.tools.util.LOGD("close_connect", socket.toString());
                this.aj.close();
            } catch (java.lang.Exception e2) {
                oicq.wlogin_sdk.tools.util.printException(e2, "");
            }
            this.aj = null;
        }
    }

    public void i() {
        oicq.wlogin_sdk.tools.util.LOGD("close_transport_connect", "close_transport_connect");
        java.net.Socket socket = this.ak;
        if (socket != null) {
            try {
                oicq.wlogin_sdk.tools.util.LOGD("close_transport_connect", socket.toString());
                this.ak.close();
            } catch (java.lang.Exception e2) {
                oicq.wlogin_sdk.tools.util.printException(e2, "");
            }
            this.ak = null;
        }
    }

    public synchronized void j() {
        al.a();
    }

    public synchronized java.util.List k() {
        return al.a(true);
    }
}
