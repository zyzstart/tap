package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BlockingAudioTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1509a = "TTS.BlockingAudioTrack";
    private static final boolean b = false;
    private static final long c = 20;
    private static final long d = 2500;
    private static final long e = 2500;
    private static final int f = 8192;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private int n;
    private final java.lang.Object q = new java.lang.Object();
    private boolean l = false;
    private int m = 0;
    private android.media.AudioTrack o = null;
    private volatile boolean p = false;

    public BlockingAudioTrack(int i, int i2, int i3, int i4) {
        this.n = 0;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = c(this.i) * this.j;
        this.n = 0;
    }

    static int a(int i) {
        if (i == 1) {
            return 4;
        }
        return i == 2 ? 12 : 0;
    }

    private static int a(android.media.AudioTrack audioTrack, byte[] bArr) {
        int iWrite;
        if (audioTrack.getPlayState() != 3) {
            audioTrack.play();
        }
        int i = 0;
        while (i < bArr.length && (iWrite = audioTrack.write(bArr, i, bArr.length)) > 0) {
            i += iWrite;
        }
        return i;
    }

    private static final long a(long j, long j2, long j3) {
        if (j < j2) {
            return j2;
        }
        return j > j3 ? j3 : j;
    }

    private android.media.AudioTrack a() {
        int iA = a(this.j);
        int iMax = java.lang.Math.max(8192, android.media.AudioTrack.getMinBufferSize(this.h, iA, this.i));
        android.media.AudioTrack audioTrack = new android.media.AudioTrack(this.g, this.h, iA, this.i, iMax, 1);
        if (audioTrack.getState() == 1) {
            this.m = iMax;
            return audioTrack;
        }
        com.unisound.common.y.e(f1509a, "Unable to create audio track.");
        audioTrack.release();
        return null;
    }

    private void a(android.media.AudioTrack audioTrack) {
        if (this.n <= 0) {
            return;
        }
        if (this.l) {
            b();
        } else {
            b(audioTrack);
        }
    }

    private void b() {
        try {
            java.lang.Thread.sleep(((this.n / this.k) * 1000) / this.h);
        } catch (java.lang.InterruptedException unused) {
        }
    }

    private void b(android.media.AudioTrack audioTrack) {
        int i = this.n / this.k;
        int i2 = -1;
        long j = 0;
        while (true) {
            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
            if (playbackHeadPosition >= i || audioTrack.getPlayState() != 3 || this.p) {
                return;
            }
            long jA = a(((i - playbackHeadPosition) * 1000) / audioTrack.getSampleRate(), c, 2500L);
            if (playbackHeadPosition == i2) {
                j += jA;
                if (j > 2500) {
                    com.unisound.common.y.e(f1509a, "Waited unsuccessfully for ", 2500L, "ms ", "for AudioTrack to make progress, Aborting");
                    return;
                }
            } else {
                j = 0;
            }
            try {
                java.lang.Thread.sleep(jA);
                i2 = playbackHeadPosition;
            } catch (java.lang.InterruptedException unused) {
                return;
            }
        }
    }

    private static int c(int i) {
        if (i == 3) {
            return 1;
        }
        return i == 2 ? 2 : -1;
    }

    long b(int i) {
        return ((i / this.k) * 1000) / this.h;
    }

    public void init() {
        android.media.AudioTrack audioTrackA = a();
        synchronized (this.q) {
            this.o = audioTrackA;
        }
    }

    public void start() {
        android.media.AudioTrack audioTrack = this.o;
        if (audioTrack == null || audioTrack.getPlayState() == 3) {
            return;
        }
        this.o.play();
    }

    public void stop() {
        synchronized (this.q) {
            if (this.o != null) {
                this.o.stop();
            }
        }
        this.p = true;
    }

    public void waitAndRelease() {
        if (this.o == null) {
            return;
        }
        if (this.n < this.m && !this.p) {
            this.l = true;
            this.o.stop();
        }
        if (!this.p) {
            a(this.o);
        }
        synchronized (this.q) {
            this.o.release();
            this.o = null;
        }
    }

    public int write(byte[] bArr) {
        if (this.o == null || this.p) {
            return -1;
        }
        int iA = a(this.o, bArr);
        this.n += iA;
        return iA;
    }

    public int write(byte[] bArr, int i, int i2) {
        if (this.o == null || this.p) {
            return -1;
        }
        return this.o.write(bArr, i, i2);
    }
}
