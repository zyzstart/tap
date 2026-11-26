package org.fmod;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.fmod.FMODAudioDevice f1693a;
    private final java.nio.ByteBuffer b;
    private final int c;
    private final int d;
    private final int e = 2;
    private volatile java.lang.Thread f;
    private volatile boolean g;
    private android.media.AudioRecord h;
    private boolean i;

    a(org.fmod.FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f1693a = fMODAudioDevice;
        this.c = i;
        this.d = i2;
        this.b = java.nio.ByteBuffer.allocateDirect(android.media.AudioRecord.getMinBufferSize(i, i2, 2));
    }

    private void d() {
        android.media.AudioRecord audioRecord = this.h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.h.stop();
            }
            this.h.release();
            this.h = null;
        }
        this.b.position(0);
        this.i = false;
    }

    public final int a() {
        return this.b.capacity();
    }

    public final void b() {
        if (this.f != null) {
            c();
        }
        this.g = true;
        this.f = new java.lang.Thread(this);
        this.f.start();
    }

    public final void c() {
        while (this.f != null) {
            this.g = false;
            try {
                this.f.join();
                this.f = null;
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.g) {
            if (!this.i && i > 0) {
                d();
                this.h = new android.media.AudioRecord(1, this.c, this.d, this.e, this.b.capacity());
                this.i = this.h.getState() == 1;
                if (this.i) {
                    this.b.position(0);
                    this.h.startRecording();
                    i = 3;
                } else {
                    android.util.Log.e("FMOD", "AudioRecord failed to initialize (status " + this.h.getState() + ")");
                    i += -1;
                    d();
                }
            }
            if (this.i && this.h.getRecordingState() == 3) {
                android.media.AudioRecord audioRecord = this.h;
                java.nio.ByteBuffer byteBuffer = this.b;
                this.f1693a.fmodProcessMicData(this.b, audioRecord.read(byteBuffer, byteBuffer.capacity()));
                this.b.position(0);
            }
        }
        d();
    }
}
