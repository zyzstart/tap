package cn.yunzhisheng.tts.offline.lib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YzsTts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cn.yunzhisheng.tts.offline.lib.YzsTts f9a;
    private static volatile boolean d;
    private long b = 0;
    private long c = 0;
    private java.lang.Object e = new java.lang.Object();
    private java.io.InputStream[] f;

    static {
        java.lang.System.loadLibrary("yzstts");
        f9a = null;
        d = false;
    }

    public static cn.yunzhisheng.tts.offline.lib.YzsTts b() {
        if (f9a == null) {
            f9a = new cn.yunzhisheng.tts.offline.lib.YzsTts();
        }
        return f9a;
    }

    private native void cancel(long j);

    private native int changeSpeaker(long j, java.lang.String str);

    private native long create(long j);

    private native long createbase(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    private native long createbase2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    private native java.lang.String getCheckInfo(java.lang.Object obj);

    private native java.lang.String getOption(long j, int i);

    private native int predictWavLenMs(long j);

    private native void release(long j);

    private native void releasebase(long j);

    private native int setOption(long j, int i, java.lang.String str);

    public int a(long j, byte[] bArr) {
        int iReceiveSamples;
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("YzsTts process receiveData start");
        }
        if (j == 0) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("YzsTts process receiveData end");
            }
            return 0;
        }
        synchronized (this.e) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("YzsTts receiveSamples start");
            }
            iReceiveSamples = receiveSamples(j, bArr);
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("YzsTts receiveSamples end handle = ", java.lang.Long.valueOf(j), "; audioLength = ", java.lang.Integer.valueOf(bArr.length), "; first byte", java.lang.Byte.valueOf(bArr[0]));
            }
        }
        return iReceiveSamples;
    }

    public int a(java.lang.String str) {
        if (!d()) {
            return com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_NOT_INIT;
        }
        if (d) {
            return com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_IS_PROCESSING;
        }
        synchronized (this.e) {
            if (changeSpeaker(this.c, str) == -1) {
                return com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_CHANGE_SPEAKER_FAIL;
            }
            return 114;
        }
    }

    public long a() {
        return this.c;
    }

    public void a(float f) {
        if (!d() || setOption(this.c, 0, java.lang.String.format("%1$.1f", java.lang.Float.valueOf(f))) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setLog : error");
    }

    public void a(int i) {
        if (!d() || setOption(this.c, 6, java.lang.String.valueOf(i)) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setFrontSilence : error");
    }

    public void a(java.lang.Boolean bool) {
        d = bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        c();
        if (str.equals("0")) {
            this.b = createbase2(str, str2, str3, str4);
            try {
                for (java.io.InputStream inputStream : this.f) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            this.b = createbase(str, str2, str3, str4);
        }
        if (this.b == 0) {
            return false;
        }
        synchronized (this.e) {
            this.c = create(this.b);
            return this.c != 0;
        }
    }

    public boolean a(java.io.InputStream... inputStreamArr) {
        if (inputStreamArr[0] == null || inputStreamArr[1] == null) {
            return false;
        }
        this.f = inputStreamArr;
        return a("0", "1", "2", "3");
    }

    public int b(long j, byte[] bArr) {
        int iReceiveSamples2;
        com.unisound.common.y.d("YzsTts process receiveData2 start");
        if (j == 0) {
            com.unisound.common.y.d("YzsTts process receiveData2 end");
            return 0;
        }
        synchronized (this.e) {
            com.unisound.common.y.d("YzsTts receiveSamples start");
            iReceiveSamples2 = receiveSamples2(j, bArr);
            com.unisound.common.y.d("YzsTts receiveSamples end handle = " + j + "; audioLength = " + bArr.length + "; first byte" + ((int) bArr[0]));
        }
        return iReceiveSamples2;
    }

    public void b(float f) {
        if (!d() || setOption(this.c, 1, java.lang.String.format("%1$.1f", java.lang.Float.valueOf(f))) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setVoiceSpeed : error");
    }

    public void b(int i) {
        if (!d() || setOption(this.c, 7, java.lang.String.valueOf(i)) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setBackSilence : error");
    }

    public void b(java.lang.Boolean bool) {
        if (!d() || setOption(this.c, 5, java.lang.String.valueOf(bool)) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setIsReadEnglishInPinyin : error");
    }

    public void c() {
        if (d()) {
            synchronized (this.e) {
                release(this.c);
                this.c = 0L;
            }
            releasebase(this.b);
            this.b = 0L;
            d = false;
        }
    }

    public void c(float f) {
        if (!d() || setOption(this.c, 3, java.lang.String.format("%1$.1f", java.lang.Float.valueOf(f))) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setVoiceVolume : error");
    }

    public void c(int i) {
        if (d()) {
            setOption(this.c, 5, java.lang.String.valueOf(i));
        }
    }

    public void d(float f) {
        if (!d() || setOption(this.c, 2, java.lang.String.format("%1$.1f", java.lang.Float.valueOf(f))) == 0) {
            return;
        }
        com.unisound.common.y.a("YzsTts setVoicePitch : error");
    }

    public boolean d() {
        return this.c != 0;
    }

    public boolean d(int i) {
        return d() && setOption(this.c, 6, java.lang.String.valueOf(i)) == 0;
    }

    public void e() {
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("YzsTts process cancel start");
        }
        if (d() && d) {
            synchronized (this.e) {
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("YzsTts cancel start");
                }
                cancel(this.c);
                if (com.unisound.common.y.l) {
                    com.unisound.common.y.d("YzsTts cancel end");
                }
            }
            d = false;
        }
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("YzsTts process cancel end");
        }
    }

    public void e(int i) {
        if (d()) {
            setOption(this.c, 10, java.lang.String.valueOf(i));
        }
    }

    public java.lang.String f() {
        java.lang.String checkInfo = getCheckInfo(new java.lang.Object());
        return checkInfo == null ? "" : checkInfo;
    }

    public void f(int i) {
        if (d()) {
            setOption(this.c, 11, java.lang.String.valueOf(i));
        }
    }

    public int g() {
        if (d()) {
            return predictWavLenMs(this.c);
        }
        return 0;
    }

    public void g(int i) {
        if (d()) {
            setOption(this.c, 12, java.lang.String.valueOf(i));
        }
    }

    public native int receiveSamples(long j, byte[] bArr);

    public native int receiveSamples2(long j, byte[] bArr);

    public native int setText(long j, java.lang.String str);

    protected int toGetStreamLength(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (this.f[java.lang.Integer.parseInt(str)] == null) {
                return 0;
            }
            return this.f[java.lang.Integer.parseInt(str)].available();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected int toLoadTtsResource(java.lang.String str, int i, int i2, byte[] bArr) {
        java.io.InputStream inputStream;
        if (android.text.TextUtils.isEmpty(str) || (inputStream = this.f[java.lang.Integer.parseInt(str)]) == null) {
            return 0;
        }
        try {
            int iAvailable = inputStream.available();
            if (iAvailable >= i2) {
                iAvailable = i2;
            }
            return inputStream.read(bArr, 0, iAvailable);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
