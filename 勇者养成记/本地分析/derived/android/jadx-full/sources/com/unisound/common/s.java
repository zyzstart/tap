package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1500a = 100000;
    public static final int b = 100001;
    public static final int c = 100002;
    public static final int d = 100003;
    public static final int e = 100004;
    public static final int f = 100005;
    public static final int g = 100006;
    public static final int h = 100007;
    public static final int i = 100008;
    public static final int j = 100009;
    public static final int k = 100010;
    private static final java.lang.String r = "USCFourMic";
    private static final boolean s = false;
    private android.media.AudioManager t;
    private com.unisound.jni.Uni4micHalJNI u;
    private boolean v = false;
    private boolean w = true;
    public boolean l = false;
    public boolean m = false;
    int n = 0;
    int o = 0;
    public java.lang.String p = android.os.Environment.getExternalStorageDirectory().getPath() + "/YunZhiSheng/4mic/";
    public java.lang.String q = "";
    private boolean x = false;
    private int y = 0;
    private boolean z = false;

    public s(android.media.AudioManager audioManager) {
        this.t = audioManager;
    }

    private void b(java.lang.String str) {
        int iLastIndexOf;
        if (str != null && (iLastIndexOf = str.lastIndexOf(47)) >= 0) {
            new java.io.File(str.substring(0, iLastIndexOf)).mkdirs();
        }
    }

    private void c(java.lang.String str) {
        if (this.l && this.m) {
            android.util.Log.d(r, str);
        }
    }

    private boolean u() {
        return 1 == d();
    }

    private boolean v() {
        return e().contains("UNI_4MIC_HAL_ANDROID");
    }

    public int a(int i2, int i3) {
        return ((i2 / 2) * 1000) / i3;
    }

    public void a(int i2) {
        if (a() && u()) {
            c("set4MicWakeup -> " + i2);
            this.t.adjustStreamVolume(100000, 0, i2);
        }
        c("print debug log set4MicWakeup -> " + i2);
    }

    public void a(java.lang.String str) {
        this.q = str;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean a() {
        return this.l;
    }

    public boolean a(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        if (!a() || !f()) {
            return false;
        }
        b(str);
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArr);
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
        }
    }

    public byte[][] a(byte[] bArr) {
        byte[][] bArr2 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 2, bArr.length / 2);
        int i2 = 0;
        while (true) {
            int i3 = i2 * 4;
            int i4 = i3 + 2;
            if (i4 >= bArr.length) {
                return bArr2;
            }
            int i5 = i2 * 2;
            java.lang.System.arraycopy(bArr, i3, bArr2[0], i5, 2);
            java.lang.System.arraycopy(bArr, i4, bArr2[1], i5, 2);
            i2++;
        }
    }

    public int b() {
        if (a() && u()) {
            return this.t.getVibrateSetting(c);
        }
        return -1;
    }

    public void b(int i2) {
        if (a() && v()) {
            c("_set4MicWakeup -> " + i2);
            this.u.set4MicWakeUpStatus(i2);
        }
        c("print debug log _set4MicWakeup -> " + i2);
    }

    public void b(boolean z) {
        if (a() && u()) {
            this.t.adjustStreamVolume(e, 0, z ? 1 : 0);
            c("setDebugMode set To board  -> " + z);
        }
        c("setDebugMode  -> " + z);
        this.m = z;
    }

    public void b(byte[] bArr) throws java.lang.Throwable {
        if (a() && f()) {
            a(bArr, this.p + this.q + "_real.pcm");
        }
    }

    public int c() {
        if (a() && v()) {
            return this.u.get4MicDoaResult();
        }
        return -1;
    }

    public void c(int i2) {
        if (a() && u()) {
            c("set4MicDoaTimeLen -> " + i2);
            this.t.adjustStreamVolume(b, 0, i2);
        }
    }

    public void c(boolean z) {
        if (a() && v()) {
            this.u.set4MicDebugMode(z ? 1 : 0);
            c("setDebugMode set To board  -> " + z);
        }
        c("setDebugMode  -> " + z);
        this.m = z;
    }

    public void c(byte[] bArr) throws java.lang.Throwable {
        if (a() && f()) {
            a(bArr, this.p + this.q + "_asr.pcm");
        }
    }

    public int d() {
        if (a()) {
            return this.t.getVibrateSetting(d);
        }
        return -1;
    }

    public void d(int i2) {
        if (a() && v()) {
            c("set4MicDoaTimeLen -> " + i2);
            this.u.set4MicUtteranceTimeLen(i2);
        }
        c("print debug log _set4MicDoaTimeLen -> " + i2);
    }

    public void d(boolean z) {
        if (u()) {
            this.t.adjustStreamVolume(g, 0, !z ? 1 : 0);
            c("close4MicAlgorithm set To board  -> " + z);
        }
    }

    public void d(byte[] bArr) throws java.lang.Throwable {
        if (a() && f()) {
            a(bArr, this.p + this.q + "_vad.pcm");
        }
    }

    public java.lang.String e() {
        return a() ? this.u.get4MicBoardVersion() : "";
    }

    public void e(int i2) {
        this.n += i2;
    }

    public void e(boolean z) {
        if (v()) {
            this.u.close4MicAlgorithm(z ? 1 : 0);
            com.unisound.common.y.c("FourMicUtil", "close4MicAlgorithm flag = " + (z ? 1 : 0));
            c("_close4MicAlgorithm set To board  -> " + z);
        }
    }

    public void f(int i2) {
        if (a() && u()) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.t.adjustStreamVolume(f, 0, i2);
            c("setDelayTime -> " + i2);
        }
    }

    public void f(boolean z) {
        java.lang.String str;
        if (a() && u()) {
            this.x = z;
            m(z ? 1 : 0);
            str = "setOneShotReadyFor4Mic -> " + (z ? 1 : 0);
        } else {
            str = "setOneShotReadyFor4Mic error not 4mic";
        }
        c(str);
    }

    public boolean f() {
        return this.m;
    }

    public void g() {
        this.n = 0;
    }

    public void g(int i2) {
        if (a() && v()) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.u.set4MicDelayTime(i2);
            c("setDelayTime -> " + i2);
        }
    }

    public void g(boolean z) {
        java.lang.String str;
        if (a() && v()) {
            this.x = z;
            n(z ? 1 : 0);
            str = "setOneShotReadyFor4Mic -> " + (z ? 1 : 0);
        } else {
            str = "setOneShotReadyFor4Mic error not 4mic";
        }
        c(str);
    }

    public int h() {
        return this.n;
    }

    public void h(int i2) {
        this.o = i2;
    }

    public void h(boolean z) {
        this.z = z;
    }

    public int i() {
        return this.o;
    }

    public void i(int i2) {
        if (!a() || !u()) {
            c("setOneShotTimeStart error not 4mic");
            return;
        }
        c("setOneShotTimeStart -> " + i2);
        this.t.adjustStreamVolume(h, 0, i2);
    }

    public void i(boolean z) {
        this.v = z;
    }

    public int j() {
        if (a() && u()) {
            return this.t.getVibrateSetting(k);
        }
        return -1;
    }

    public void j(int i2) {
        if (!a() || !v()) {
            c("_setOneShotTimeStart error not 4mic");
            return;
        }
        c("setOneShotTimeStart -> " + i2);
        this.u.set4MicOneShotStartLen(i2);
    }

    public void j(boolean z) {
        this.w = z;
    }

    public int k() {
        if (a() && v()) {
            this.u.get4MicOneShotReady();
        }
        return -1;
    }

    public void k(int i2) {
        if (!a() || !u()) {
            c("setStartWakeupTimeLen error not 4mic");
            return;
        }
        if (i2 < 0) {
            c("setStartWakeupTimeLen -> timeLen min");
            i2 = 0;
        } else if (i2 > Integer.MAX_VALUE) {
            c("setStartWakeupTimeLen -> timeLen max");
            i2 = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        c("setStartWakeupTimeLen -> " + i2);
        this.t.adjustStreamVolume(i, 0, i2);
    }

    public void l(int i2) {
        if (!a() || !v()) {
            c("setStartWakeupTimeLen error not 4mic");
            return;
        }
        if (i2 < 0) {
            i2 = 0;
            c("setStartWakeupTimeLen -> timeLen min");
        } else if (i2 > Integer.MAX_VALUE) {
            c("setStartWakeupTimeLen -> timeLen max");
            i2 = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        c("setStartWakeupTimeLen -> " + i2);
        this.u.set4MicWakeupStartLen(i2);
    }

    public boolean l() {
        return this.x;
    }

    public int m() {
        return this.y;
    }

    public void m(int i2) {
        if (!a() || !u()) {
            c("setOneshotReady error not 4mic");
            return;
        }
        c("setOneshotReady -> " + i2);
        this.t.adjustStreamVolume(j, 0, i2);
    }

    public void n() {
        this.y = 0;
    }

    public void n(int i2) {
        if (!a() || !v()) {
            c("setOneshotReady error not 4mic");
            return;
        }
        c("setOneshotReady -> " + i2);
        this.u.set4MicOneShotReady(i2);
    }

    public void o(int i2) {
        this.y = i2;
    }

    public boolean o() {
        return this.z;
    }

    public com.unisound.jni.Uni4micHalJNI p() {
        return this.u;
    }

    public void p(int i2) {
        this.y += i2;
    }

    public int q() {
        this.u = com.unisound.jni.Uni4micHalJNI.getInstance();
        int iInit = this.u.init(1);
        com.unisound.common.y.c("FourMicUtil", "initFourMic status = " + iInit);
        return iInit;
    }

    public int r() {
        com.unisound.jni.Uni4micHalJNI uni4micHalJNI = this.u;
        if (uni4micHalJNI != null) {
            return uni4micHalJNI.release();
        }
        return -1;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }
}
