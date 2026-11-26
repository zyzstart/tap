package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechSynthesizer {
    public static final java.lang.String FORMAT_MP3 = "mp3";
    public static final java.lang.String FORMAT_PCM = "pcm";
    public static final int METHOD_NUS = 1;
    public static final int METHOD_RUS = 0;
    public static final java.lang.String SAMPLE_RATE_16K = "16000";
    public static final java.lang.String SAMPLE_RATE_8K = "8000";
    public static final java.lang.String VOICE_XIAOGANG = "xiaogang";
    public static final java.lang.String VOICE_XIAOYUN = "xiaoyun";
    private long request;
    private boolean started = false;

    SpeechSynthesizer(long j) {
        this.request = 0L;
        this.request = j;
    }

    private native void releaseRequest(long j);

    private native int setAppKey(long j, java.lang.String str);

    private native int setFormat(long j, java.lang.String str);

    private native int setMethod(long j, int i);

    private native int setParams(long j, java.lang.String str);

    private native int setPitchRate(long j, int i);

    private native int setSampleRate(long j, int i);

    private native int setSpeechRate(long j, int i);

    private native int setText(long j, java.lang.String str);

    private native int setToken(long j, java.lang.String str);

    private native int setUrl(long j, java.lang.String str);

    private native int setVoice(long j, java.lang.String str);

    private native int setVolume(long j, int i);

    private native int start(long j);

    private native int stop(long j);

    public long getRequest() {
        return this.request;
    }

    public int setAppkey(java.lang.String str) {
        return setAppKey(this.request, str);
    }

    public int setFormat(java.lang.String str) {
        return setFormat(this.request, str);
    }

    public int setMethod(int i) {
        return setMethod(this.request, i);
    }

    public int setParams(java.lang.String str) {
        return setParams(this.request, str);
    }

    public int setPitchRate(int i) {
        return setPitchRate(this.request, i);
    }

    public int setSampleRate(java.lang.String str) {
        if (SAMPLE_RATE_16K.equals(str)) {
            return setSampleRate(this.request, 16000);
        }
        if (SAMPLE_RATE_8K.equals(str)) {
            return setSampleRate(this.request, 8000);
        }
        throw new java.lang.IllegalArgumentException("Unsupported sample rate: " + str);
    }

    public int setSpeechRate(int i) {
        return setSpeechRate(this.request, i);
    }

    public int setText(java.lang.String str) {
        return setText(this.request, str);
    }

    public int setToken(java.lang.String str) {
        return setToken(this.request, str);
    }

    public int setUrl(java.lang.String str) {
        return setUrl(this.request, str);
    }

    public int setVoice(java.lang.String str) {
        return setVoice(this.request, str);
    }

    public int setVolume(int i) {
        return setVolume(this.request, i);
    }

    public int start() {
        if (this.started) {
            return 0;
        }
        this.started = true;
        return start(this.request);
    }

    public int stop() {
        if (!this.started) {
            return 0;
        }
        this.started = false;
        int iStop = stop(this.request);
        releaseRequest(this.request);
        this.request = 0L;
        return iStop;
    }
}
