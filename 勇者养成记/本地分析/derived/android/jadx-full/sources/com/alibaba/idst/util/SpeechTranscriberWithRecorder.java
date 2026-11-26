package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechTranscriberWithRecorder implements com.alibaba.idst.util.RecorderCallbackWithStatus, com.alibaba.idst.util.SpeechTranscriberCallback {
    private static final java.lang.String TAG = "AliSpeechSDK";
    private com.alibaba.idst.util.NlsClient client;
    private com.alibaba.idst.util.SpeechTranscriber transcriber;
    private com.alibaba.idst.util.SpeechTranscriberWithRecorderCallback userCallback;
    private com.alibaba.idst.util.DefaultRecorder recorder = new com.alibaba.idst.util.DefaultRecorder(this);
    private com.alibaba.idst.util.RecognizerParameters parameters = new com.alibaba.idst.util.RecognizerParameters();

    SpeechTranscriberWithRecorder(com.alibaba.idst.util.NlsClient nlsClient) {
        this.client = nlsClient;
    }

    public void enableIntermediateResult(boolean z) {
        this.parameters.setIntermediateResult(java.lang.Boolean.valueOf(z));
    }

    public void enableInverseTextNormalization(boolean z) {
        this.parameters.setInverseTextNormalization(java.lang.Boolean.valueOf(z));
    }

    public void enablePunctuationPrediction(boolean z) {
        this.parameters.setPunctuationPrediction(z);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onChannelClosed(java.lang.String str, int i) {
        this.userCallback.onChannelClosed(str, i);
    }

    @Override // com.alibaba.idst.util.RecorderCallbackWithStatus
    public void onPost() {
        this.transcriber.stop();
    }

    @Override // com.alibaba.idst.util.RecorderCallbackWithStatus
    public void onPre() {
        android.util.Log.d(TAG, "Transcriber with recorder starting...");
        this.transcriber = this.client.createTranscriberRequest(this);
        this.transcriber.setToken(this.parameters.getToken());
        this.transcriber.setAppkey(this.parameters.getAppkey());
        if (this.parameters.getIntermediateResult() != null) {
            this.transcriber.enableIntermediateResult(this.parameters.getIntermediateResult().booleanValue());
        }
        if (this.parameters.getInverseTextNormalization() != null) {
            this.transcriber.enableInverseTextNormalization(this.parameters.getInverseTextNormalization().booleanValue());
        }
        if (this.parameters.getPunctuationPrediction() != null) {
            this.transcriber.enablePunctuationPrediction(this.parameters.getPunctuationPrediction().booleanValue());
        }
        if (this.parameters.getParams() != null) {
            this.transcriber.setParams(this.parameters.getParams());
        }
        this.transcriber.start();
        android.util.Log.d(TAG, "Transcriber with recorder started!");
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onSentenceBegin(java.lang.String str, int i) {
        this.userCallback.onSentenceBegin(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onSentenceEnd(java.lang.String str, int i) {
        this.userCallback.onSentenceEnd(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onTaskFailed(java.lang.String str, int i) {
        this.recorder.stop();
        this.userCallback.onTaskFailed(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onTranscriptionCompleted(java.lang.String str, int i) {
        this.recorder.stop();
        this.userCallback.onTranscriptionCompleted(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onTranscriptionResultChanged(java.lang.String str, int i) {
        this.userCallback.onTranscriptionResultChanged(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechTranscriberCallback
    public void onTranscriptionStarted(java.lang.String str, int i) {
        this.userCallback.onTranscriptionStarted(str, i);
    }

    @Override // com.alibaba.idst.util.RecorderCallback
    public void onVoiceData(byte[] bArr, int i) {
        if (this.transcriber.sendAudio(bArr, i) < 0) {
            throw new java.lang.IllegalStateException("Send audio failed.");
        }
        this.userCallback.onVoiceData(bArr, i);
    }

    @Override // com.alibaba.idst.util.RecorderCallback
    public void onVoiceVolume(int i) {
        this.userCallback.onVoiceVolume(i);
    }

    public void setAppkey(java.lang.String str) {
        this.parameters.setAppkey(str);
    }

    public void setParams(java.lang.String str) {
        this.parameters.setParams(str);
    }

    public void setToken(java.lang.String str) {
        this.parameters.setToken(str);
    }

    public void setUserCallback(com.alibaba.idst.util.SpeechTranscriberWithRecorderCallback speechTranscriberWithRecorderCallback) {
        this.userCallback = speechTranscriberWithRecorderCallback;
    }

    public int start() {
        this.recorder.start();
        return 0;
    }

    public int stop() {
        this.recorder.stop();
        return 0;
    }
}
