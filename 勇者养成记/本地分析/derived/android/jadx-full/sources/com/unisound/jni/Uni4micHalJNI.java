package com.unisound.jni;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Uni4micHalJNI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.unisound.jni.Uni4micHalJNI f1508a;
    private boolean b = false;

    static {
        java.lang.System.loadLibrary("Uni4micHalJNI");
    }

    private Uni4micHalJNI() {
    }

    public static com.unisound.jni.Uni4micHalJNI getInstance() {
        if (f1508a == null) {
            f1508a = new com.unisound.jni.Uni4micHalJNI();
        }
        return f1508a;
    }

    private native int initHal(int i);

    private native int releaseHal();

    public native int close4MicAlgorithm(int i);

    public native int closeAudioIn(long j);

    public native java.lang.String get4MicBoardVersion();

    public native int get4MicDoaResult();

    public native int get4MicOneShotReady();

    public int init(int i) {
        if (this.b) {
            return 0;
        }
        int iInitHal = f1508a.initHal(i);
        if (iInitHal != 0) {
            return iInitHal;
        }
        this.b = true;
        return iInitHal;
    }

    public native long openAudioIn(int i);

    public native int readData(long j, byte[] bArr, int i);

    public int release() {
        if (!this.b) {
            return -1;
        }
        int iReleaseHal = f1508a.releaseHal();
        if (iReleaseHal != 0) {
            return iReleaseHal;
        }
        this.b = false;
        return iReleaseHal;
    }

    public native int set4MicDebugMode(int i);

    public native int set4MicDelayTime(int i);

    public native int set4MicOneShotReady(int i);

    public native int set4MicOneShotStartLen(int i);

    public native int set4MicUtteranceTimeLen(int i);

    public native int set4MicWakeUpStatus(int i);

    public native int set4MicWakeupStartLen(int i);

    public native int startRecorder(long j);

    public native int stopRecorder(long j);
}
