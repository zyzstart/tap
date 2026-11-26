package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.unisound.client.IAudioSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1488a = 16000;
    protected static int b = 16;
    protected static int c = 16;
    protected static int d = 12;
    protected static int e = 2;
    protected static int f = 4;
    protected static int g = 1;
    private static int h = 16000;
    private static int i = 6400;
    private cn.yunzhisheng.asr.a l;
    private com.unisound.sdk.bx m;
    private com.unisound.jni.Uni4micHalJNI o;
    private android.media.AudioRecord j = null;
    private java.lang.Object k = new java.lang.Object();
    private com.unisound.sdk.BlockingAudioTrack n = null;
    private long p = -1;

    static {
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(h, b, e);
        if (i < minBufferSize) {
            i = minBufferSize;
        }
    }

    public e() {
    }

    public e(cn.yunzhisheng.asr.a aVar) {
        this.l = aVar;
    }

    public e(com.unisound.sdk.bx bxVar) {
        this.m = bxVar;
    }

    private int a() {
        com.unisound.common.y.c("AudioSourceImpl", "openOut begin");
        synchronized (this.k) {
            this.n = new com.unisound.sdk.BlockingAudioTrack(this.m.E(), this.m.C(), 2, 1);
            com.unisound.common.y.c("AudioSourceImpl", "openOut audioTrack init");
            this.n.init();
            com.unisound.common.y.c("AudioSourceImpl", "openOut audioTrack start");
            this.n.start();
        }
        com.unisound.common.y.c("AudioSourceImpl", "openOut end");
        return 0;
    }

    private int a(byte[] bArr, int i2) {
        com.unisound.sdk.BlockingAudioTrack blockingAudioTrack = this.n;
        if (blockingAudioTrack != null) {
            return blockingAudioTrack.write(bArr, 0, i2);
        }
        return 0;
    }

    private int b(byte[] bArr, int i2) {
        if (this.l.c != null && this.l.c.a() && this.l.c.s()) {
            com.unisound.jni.Uni4micHalJNI uni4micHalJNI = this.o;
            if (uni4micHalJNI != null) {
                return uni4micHalJNI.readData(this.p, bArr, i2);
            }
            return 0;
        }
        android.media.AudioRecord audioRecord = this.j;
        if (audioRecord != null) {
            return audioRecord.read(bArr, 0, i2);
        }
        return 0;
    }

    private void b() {
        com.unisound.common.y.c("AudioSourceImpl", "closeOut begin");
        synchronized (this.k) {
            if (this.n != null) {
                com.unisound.common.y.c("AudioSourceImpl", "closeOut call stop");
                this.n.stop();
                com.unisound.common.y.c("AudioSourceImpl", "closeOut call release");
                this.n.waitAndRelease();
                this.n = null;
            }
        }
        com.unisound.common.y.c("AudioSourceImpl", "closeOut end");
    }

    private int c() {
        java.lang.Object[] objArr;
        com.unisound.common.y.c("AudioSourceImpl openIn begin");
        if (this.l.c == null || !this.l.c.a()) {
            com.unisound.common.y.c("AudioSourceImpl", "openIn audioRecord init");
            this.j = new android.media.AudioRecord(this.l.e(), this.l.f(), c, e, i);
            if (this.j.getState() == 1) {
                com.unisound.common.y.c("AudioSourceImpl", "openIn audioRecord start");
                this.j.startRecording();
                com.unisound.common.y.c("AudioSourceImpl", "openIn end");
                return 0;
            }
        } else {
            if (this.l.c.s()) {
                com.unisound.jni.Uni4micHalJNI uni4micHalJNIP = this.l.c.p();
                this.o = uni4micHalJNIP;
                if (uni4micHalJNIP != null) {
                    com.unisound.common.y.c("AudioSourceImpl openIn uni4micHalJNI openIn is RK_tinyAlsa");
                    this.p = this.o.openAudioIn(2);
                    com.unisound.common.y.c("AudioSourceImpl openIn uni4micHalJNI openAudioIn = " + this.p);
                    int iStartRecorder = this.o.startRecorder(this.p);
                    com.unisound.common.y.c("AudioSourceImpl openIn uni4micHalJNI startRecorder status = " + iStartRecorder);
                    if (iStartRecorder == 0) {
                        com.unisound.common.y.c("AudioSourceImpl openIn end");
                        return 0;
                    }
                    objArr = new java.lang.Object[]{"AudioSourceImpl openIn end"};
                } else {
                    objArr = new java.lang.Object[]{"AudioSourceImpl openIn end"};
                }
                com.unisound.common.y.c(objArr);
                return -1;
            }
            com.unisound.common.y.c("AudioSourceImpl openIn audioRecord init");
            this.j = new android.media.AudioRecord(this.l.e(), this.l.f(), d, e, i);
            if (this.j.getState() == 1) {
                com.unisound.common.y.c("AudioSourceImpl openIn audioRecord start");
                this.j.startRecording();
                com.unisound.common.y.c("AudioSourceImpl openIn end");
                return 0;
            }
        }
        return -1;
    }

    private void d() {
        com.unisound.common.y.c("AudioSourceImpl", "closeIn begin");
        if (this.l.c == null || !this.l.c.a() || !this.l.c.s()) {
            android.media.AudioRecord audioRecord = this.j;
            if (audioRecord != null) {
                if (audioRecord.getState() == 1) {
                    com.unisound.common.y.c("AudioSourceImpl closeIn audioRecord.stop()");
                    this.j.stop();
                }
                com.unisound.common.y.c("IAudioSourceImpl closeIn audioRecord.release()");
                this.j.release();
                this.j = null;
                com.unisound.common.y.c("AudioSourceImpl closeIn ok");
            }
        } else if (this.o != null) {
            com.unisound.common.y.c("AudioSourceImpl closeIn is RK_tinyAlsa");
            com.unisound.common.y.c("AudioSourceImpl closeIn uni4micHalJNI stop = " + this.o.stopRecorder(this.p));
            com.unisound.common.y.c("AudioSourceImpl closeIn uni4micHalJNI close = " + this.o.closeAudioIn(this.p));
        }
        com.unisound.common.y.c("AudioSourceImpl", "closeIn end");
    }

    @Override // com.unisound.client.IAudioSource
    public void closeAudioIn() {
        d();
    }

    @Override // com.unisound.client.IAudioSource
    public void closeAudioOut() {
        b();
    }

    @Override // com.unisound.client.IAudioSource
    public int openAudioIn() {
        return c();
    }

    @Override // com.unisound.client.IAudioSource
    public int openAudioOut() {
        return a();
    }

    @Override // com.unisound.client.IAudioSource
    public int readData(byte[] bArr, int i2) {
        return b(bArr, i2);
    }

    @Override // com.unisound.client.IAudioSource
    public int writeData(byte[] bArr, int i2) {
        return a(bArr, i2);
    }
}
