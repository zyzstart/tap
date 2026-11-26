package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechRecognizer {
    private long _callback;
    private long request;
    private boolean started = false;

    SpeechRecognizer(long j, long j2) {
        this.request = 0L;
        this._callback = 0L;
        this.request = j;
        this._callback = j2;
    }

    private native int enableVoiceDetection(long j, boolean z);

    private native void releaseCallback(long j);

    private native int sendAudio(long j, byte[] bArr, int i);

    private native int setAppKey(long j, java.lang.String str);

    private native int setFormat(long j, java.lang.String str);

    private native int setIntermediateResult(long j, boolean z);

    private native int setInverseTextNormalization(long j, boolean z);

    private native int setMaxEndSilence(long j, int i);

    private native int setMaxStartSilence(long j, int i);

    private native int setParams(long j, java.lang.String str);

    private native int setPunctuationPrediction(long j, boolean z);

    private native int setSampleRate(long j, int i);

    private native int setToken(long j, java.lang.String str);

    private native int setUrl(long j, java.lang.String str);

    private native int start(long j);

    private native int stop(long j);

    public int enableIntermediateResult(boolean z) {
        return setIntermediateResult(this.request, z);
    }

    public int enableInverseTextNormalization(boolean z) {
        return setInverseTextNormalization(this.request, z);
    }

    public int enablePunctuationPrediction(boolean z) {
        return setPunctuationPrediction(this.request, z);
    }

    public int enableVoiceDetection(boolean z) {
        return enableVoiceDetection(this.request, z);
    }

    public long getRequest() {
        return this.request;
    }

    public int sendAudio(byte[] bArr, int i) {
        return sendAudio(this.request, bArr, i);
    }

    public int setAppkey(java.lang.String str) {
        return setAppKey(this.request, str);
    }

    public int setFormat(java.lang.String str) {
        return setFormat(this.request, str);
    }

    public int setMaxEndSilence(int i) {
        return setMaxEndSilence(this.request, i);
    }

    public int setMaxStartSilence(int i) {
        return setMaxStartSilence(this.request, i);
    }

    public int setParams(java.lang.String str) {
        return setParams(this.request, str);
    }

    public int setSampleRate(int i) {
        return setSampleRate(this.request, 16000);
    }

    public int setToken(java.lang.String str) {
        return setToken(this.request, str);
    }

    public int setUrl(java.lang.String str) {
        return setUrl(this.request, str);
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
        releaseCallback(this._callback);
        this.request = 0L;
        return iStop;
    }
}
