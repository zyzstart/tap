package cn.yunzhisheng.tts;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JniClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7a = 0;
    public static final int b = 1;
    public static int c = 0;
    public static int d = 0;
    public static final int e = 0;
    public static final int f = 8;
    public static final int g = 14;
    public static final int h = 15;
    public static final int i = 22;
    public static final int j = 104;
    public static final int k = 203;
    public static final int l = 204;
    public static final int m = 2000;
    private long o = 0;
    private int[] p = new int[2];
    private int[] q = new int[2];
    private int[] r = new int[2];
    public cn.yunzhisheng.tts.a n = new cn.yunzhisheng.tts.a(this);

    static {
        java.lang.System.loadLibrary("uscasr");
    }

    public static java.lang.String e() {
        return nativeGetVersion();
    }

    public static native java.lang.String nativeGetVersion();

    public int a(int i2, java.lang.String str) {
        return a() ? nativeSetOption(this.o, i2, str) : com.unisound.client.ErrorCode.NO_INIT_ERROR;
    }

    public int a(java.lang.String str, java.lang.String str2) {
        return a() ? nativeStart(this.o, str, str2) : com.unisound.client.ErrorCode.NO_INIT_ERROR;
    }

    public java.lang.String a(int i2) {
        return a() ? nativeGetOption(this.o, i2) : "";
    }

    public boolean a() {
        return this.o != 0;
    }

    public boolean a(java.lang.String str) {
        b();
        this.o = nativeCreate(str);
        return a();
    }

    public boolean a(java.lang.String str, java.lang.String str2, int i2) {
        b();
        this.o = nativeCreateExt(str, str2, i2 + "");
        return a();
    }

    public int b() {
        if (!a()) {
            return 0;
        }
        int iNativeRelease = nativeRelease(this.o);
        this.o = 0L;
        return iNativeRelease;
    }

    public int b(java.lang.String str) {
        return a() ? nativeTextPut(this.o, str) : com.unisound.client.ErrorCode.NO_INIT_ERROR;
    }

    public int c() {
        return a() ? nativeStop(this.o) : com.unisound.client.ErrorCode.NO_INIT_ERROR;
    }

    public byte[] d() {
        if (!a()) {
            return null;
        }
        byte[] bArrNativeGetResult = nativeGetResult(this.o, this.p, this.q, this.r);
        cn.yunzhisheng.tts.a aVar = this.n;
        aVar.f8a = this.p[0];
        aVar.b = this.q[0];
        aVar.c = this.r[0];
        if (aVar.c == 0) {
            return bArrNativeGetResult;
        }
        return null;
    }

    protected void finalize() throws java.lang.Throwable {
        b();
        super.finalize();
    }

    public native long nativeCreate(java.lang.String str);

    public native long nativeCreateExt(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native java.lang.String nativeGetOption(long j2, int i2);

    public native byte[] nativeGetResult(long j2, int[] iArr, int[] iArr2, int[] iArr3);

    public native int nativeRelease(long j2);

    public native int nativeSetOption(long j2, int i2, java.lang.String str);

    public native int nativeStart(long j2, java.lang.String str, java.lang.String str2);

    public native int nativeStop(long j2);

    public native int nativeTextPut(long j2, java.lang.String str);
}
