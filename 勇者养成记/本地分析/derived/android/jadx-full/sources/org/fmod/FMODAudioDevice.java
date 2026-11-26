package org.fmod;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FMODAudioDevice implements java.lang.Runnable {
    private static int h = 0;
    private static int i = 1;
    private static int j = 2;
    private static int k = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile java.lang.Thread f1692a = null;
    private volatile boolean b = false;
    private android.media.AudioTrack c = null;
    private boolean d = false;
    private java.nio.ByteBuffer e = null;
    private byte[] f = null;
    private volatile org.fmod.a g;

    private native int fmodGetInfo(int i2);

    private native int fmodProcess(java.nio.ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        android.media.AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.c.stop();
            }
            this.c.release();
            this.c = null;
        }
        this.e = null;
        this.f = null;
        this.d = false;
    }

    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(java.nio.ByteBuffer byteBuffer, int i2);

    public boolean isRunning() {
        return this.f1692a != null && this.f1692a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = 3;
        while (this.b) {
            if (!this.d && i2 > 0) {
                releaseAudioTrack();
                int iFmodGetInfo = fmodGetInfo(h);
                int iRound = java.lang.Math.round(android.media.AudioTrack.getMinBufferSize(iFmodGetInfo, 3, 2) * 1.1f) & (-4);
                int iFmodGetInfo2 = fmodGetInfo(i);
                int iFmodGetInfo3 = fmodGetInfo(j) * iFmodGetInfo2 * 4;
                this.c = new android.media.AudioTrack(3, iFmodGetInfo, 3, 2, iFmodGetInfo3 > iRound ? iFmodGetInfo3 : iRound, 1);
                this.d = this.c.getState() == 1;
                if (this.d) {
                    this.e = java.nio.ByteBuffer.allocateDirect(iFmodGetInfo2 * 2 * 2);
                    this.f = new byte[this.e.capacity()];
                    this.c.play();
                    i2 = 3;
                } else {
                    android.util.Log.e("FMOD", "AudioTrack failed to initialize (status " + this.c.getState() + ")");
                    releaseAudioTrack();
                    i2 += -1;
                }
            }
            if (this.d) {
                if (fmodGetInfo(k) == 1) {
                    fmodProcess(this.e);
                    java.nio.ByteBuffer byteBuffer = this.e;
                    byteBuffer.get(this.f, 0, byteBuffer.capacity());
                    this.c.write(this.f, 0, this.e.capacity());
                    this.e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f1692a != null) {
            stop();
        }
        this.f1692a = new java.lang.Thread(this, "FMODAudioDevice");
        this.f1692a.setPriority(10);
        this.b = true;
        this.f1692a.start();
        if (this.g != null) {
            this.g.b();
        }
    }

    public synchronized int startAudioRecord(int i2, int i3, int i4) {
        if (this.g == null) {
            this.g = new org.fmod.a(this, i2, i3);
            this.g.b();
        }
        return this.g.a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void stop() {
        while (this.f1692a != null) {
            this.b = false;
            try {
                this.f1692a.join();
                this.f1692a = null;
            } catch (java.lang.InterruptedException unused) {
            }
        }
        if (this.g != null) {
            this.g.c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
    }
}
