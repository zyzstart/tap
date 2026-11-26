package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class x extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f1575a = 16;
    protected static int b = 16;
    protected static int c = 12;
    protected static int d = 2;
    protected static int e = 4;
    protected static int f = 1;
    private static int r;
    private com.unisound.jni.Uni4micHalJNI h;
    private com.unisound.client.FourMicAudioManagerListener u;
    private static int q = 16000;
    private static int t = q;
    private long i = -1;
    private boolean j = true;
    private int k = 1;
    private int l = 2;
    private int m = 1;
    private int n = 0;
    private int o = 0;
    private android.media.AudioRecord p = null;
    int g = 0;
    private int s = 1200;
    private java.util.concurrent.atomic.AtomicBoolean v = new java.util.concurrent.atomic.AtomicBoolean(false);

    static {
        r = 6400;
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(t, f1575a, d);
        if (r < minBufferSize) {
            r = minBufferSize;
        }
    }

    public x(com.unisound.client.FourMicAudioManagerListener fourMicAudioManagerListener) {
        this.u = null;
        this.u = fourMicAudioManagerListener;
    }

    private int a() {
        if (!this.j) {
            this.p = new android.media.AudioRecord(this.g, q, b, d, r);
            if (this.p.getState() != 1) {
                return -1;
            }
            this.p.startRecording();
            return 0;
        }
        com.unisound.jni.Uni4micHalJNI uni4micHalJNI = this.h;
        if (uni4micHalJNI != null) {
            this.i = uni4micHalJNI.openAudioIn(this.l);
            int iStartRecorder = this.h.startRecorder(this.i);
            com.unisound.common.y.c("FourMicAudioManagerInterface", "openIn uni4micHalJNI status = " + iStartRecorder);
            if (iStartRecorder == 0) {
                return 0;
            }
        }
        return -1;
    }

    private int a(byte[] bArr, int i) {
        if (this.j) {
            com.unisound.jni.Uni4micHalJNI uni4micHalJNI = this.h;
            if (uni4micHalJNI != null) {
                return uni4micHalJNI.readData(this.i, bArr, i);
            }
            return 0;
        }
        android.media.AudioRecord audioRecord = this.p;
        if (audioRecord != null) {
            return audioRecord.read(bArr, 0, i);
        }
        return 0;
    }

    private void b() {
        if (!this.j) {
            if (this.p != null) {
                com.unisound.common.y.c("FourMicAudioManagerInterface::close audioRecord.stop()");
                if (this.p.getState() == 1) {
                    this.p.stop();
                }
                com.unisound.common.y.c("FourMicAudioManagerInterface::close audioRecord.release()");
                this.p.release();
                this.p = null;
                com.unisound.common.y.c("FourMicAudioManagerInterface::close ok");
                return;
            }
            return;
        }
        com.unisound.jni.Uni4micHalJNI uni4micHalJNI = this.h;
        if (uni4micHalJNI != null) {
            com.unisound.common.y.c("FourMicAudioManagerInterface", "closeIn uni4micHalJNI stop = " + uni4micHalJNI.stopRecorder(this.i) + ", close = " + this.h.closeAudioIn(this.i));
        }
    }

    private int c() {
        this.h = com.unisound.jni.Uni4micHalJNI.getInstance();
        int iInit = this.h.init(this.k);
        com.unisound.common.y.c("FourMicAudioManagerInterface initFourMic status = " + iInit);
        this.h.set4MicDebugMode(this.m);
        this.h.close4MicAlgorithm(this.n);
        this.h.set4MicWakeUpStatus(this.o);
        return iInit;
    }

    private int d() {
        return this.h.release();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.u.onEvent(1032);
        try {
            try {
                if (this.j) {
                    c();
                }
                a();
                this.v.set(true);
                while (this.v.get()) {
                    byte[] bArr = this.j ? new byte[this.s * 2] : new byte[this.s];
                    int iA = a(bArr, bArr.length);
                    if (iA > 0) {
                        this.u.onRecordingData(bArr, iA);
                    }
                }
                b();
                if (this.j) {
                    d();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                this.u.onError(com.unisound.client.ErrorCode.toMessage(com.unisound.client.ErrorCode.ASR_FOURMIC_RECORDING_ERROR));
                b();
                if (this.j) {
                    d();
                }
            }
            this.u.onEvent(1033);
        } catch (java.lang.Throwable th) {
            b();
            if (this.j) {
                d();
            }
            throw th;
        }
    }

    protected void setOption(int i, java.lang.Object obj) {
        java.lang.String str;
        try {
            if (i != 1044) {
                if (i == 1080) {
                    try {
                        this.s = ((java.lang.Integer) obj).intValue();
                        return;
                    } catch (java.lang.Exception unused) {
                        str = "set recordingPacSize Error.";
                    }
                } else if (i == 1111) {
                    try {
                        if (((java.lang.Boolean) obj).booleanValue()) {
                            this.k = 1;
                        } else {
                            this.k = 0;
                        }
                        return;
                    } catch (java.lang.Exception unused2) {
                        str = "set use4mic Error.";
                    }
                } else if (i == 2222) {
                    try {
                        this.l = ((java.lang.Integer) obj).intValue();
                        return;
                    } catch (java.lang.Exception unused3) {
                        str = "set 4mic_ch_num Error.";
                    }
                } else if (i == 3333) {
                    this.g = ((java.lang.Integer) obj).intValue();
                } else if (i == 4444) {
                    try {
                        this.o = ((java.lang.Integer) obj).intValue();
                        return;
                    } catch (java.lang.Exception unused4) {
                        str = "set wakeupStatus Error.";
                    }
                } else if (i != 10100) {
                    switch (i) {
                        case com.unisound.client.SpeechConstants.ASR_FOURMIC_ISDEBUG /* 10198 */:
                            try {
                                boolean zBooleanValue = ((java.lang.Boolean) obj).booleanValue();
                                if (zBooleanValue) {
                                    this.m = 1;
                                } else {
                                    this.m = 0;
                                }
                                com.unisound.common.y.k = zBooleanValue;
                                return;
                            } catch (java.lang.Exception unused5) {
                                str = "set ASR_FOURMIC_ISDEBUG Error.";
                            }
                            break;
                        case com.unisound.client.SpeechConstants.ASR_FOURMIC /* 10199 */:
                            try {
                                this.j = ((java.lang.Boolean) obj).booleanValue();
                                return;
                            } catch (java.lang.Exception unused6) {
                                str = "set is4micMode Error.";
                            }
                            break;
                        default:
                            return;
                    }
                } else {
                    try {
                        if (((java.lang.Boolean) obj).booleanValue()) {
                            this.n = 1;
                        } else {
                            this.n = 0;
                        }
                        return;
                    } catch (java.lang.Exception unused7) {
                        str = "set ASR_FOURMIC_CLOSE_4MICALGORITHM Error.";
                    }
                }
                com.unisound.common.y.a(str);
                return;
            }
            q = ((java.lang.Integer) obj).intValue();
        } catch (java.lang.Exception unused8) {
            str = "set asr_sampling_rate Error.";
        }
    }

    protected void startRecord() {
        waitEnd();
        start();
    }

    protected void stopRecord() {
        waitEnd();
    }

    public void waitEnd() {
        this.v.set(false);
        if (isAlive()) {
            try {
                join(3900L);
                com.unisound.common.y.c("FourMicAudioManagerInferface::waitEnd()");
            } catch (java.lang.InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
