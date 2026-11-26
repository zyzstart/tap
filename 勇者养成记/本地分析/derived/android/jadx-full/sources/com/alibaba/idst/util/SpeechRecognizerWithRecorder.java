package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechRecognizerWithRecorder implements com.alibaba.idst.util.RecorderCallbackWithStatus, com.alibaba.idst.util.SpeechRecognizerCallback {
    private static final java.lang.String TAG = "AliSpeechSDK";
    private com.alibaba.idst.util.NlsClient client;
    private com.alibaba.idst.util.SpeechRecognizer recognizer;
    private com.alibaba.idst.util.SpeechRecognizerWithRecorderCallback userCallback;
    private com.alibaba.idst.util.DefaultRecorder recorder = new com.alibaba.idst.util.DefaultRecorder(this);
    private com.alibaba.idst.util.RecognizerParameters parameters = new com.alibaba.idst.util.RecognizerParameters();

    SpeechRecognizerWithRecorder(com.alibaba.idst.util.NlsClient nlsClient) {
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

    public void enableVoiceDetection(boolean z) {
        this.parameters.enableVoiceDetection(java.lang.Boolean.valueOf(z));
    }

    @Override // com.alibaba.idst.util.SpeechRecognizerCallback
    public void onChannelClosed(java.lang.String str, int i) {
        this.userCallback.onChannelClosed(str, i);
    }

    @Override // com.alibaba.idst.util.RecorderCallbackWithStatus
    public void onPost() {
        android.util.Log.d(TAG, "Stopping recognizer");
        this.recognizer.stop();
    }

    @Override // com.alibaba.idst.util.RecorderCallbackWithStatus
    public void onPre() {
        android.util.Log.d(TAG, "Recognizer with recorder starting...");
        this.recognizer = this.client.createRecognizerRequest(this);
        this.recognizer.setToken(this.parameters.getToken());
        this.recognizer.setAppkey(this.parameters.getAppkey());
        if (this.parameters.getIntermediateResult() != null) {
            this.recognizer.enableIntermediateResult(this.parameters.getIntermediateResult().booleanValue());
        }
        if (this.parameters.getInverseTextNormalization() != null) {
            this.recognizer.enableInverseTextNormalization(this.parameters.getInverseTextNormalization().booleanValue());
        }
        if (this.parameters.getPunctuationPrediction() != null) {
            this.recognizer.enablePunctuationPrediction(this.parameters.getPunctuationPrediction().booleanValue());
        }
        if (this.parameters.getVoiceDetection() != null) {
            this.recognizer.enableVoiceDetection(this.parameters.getVoiceDetection().booleanValue());
        }
        if (this.parameters.getMaxStartSilence() != null) {
            this.recognizer.setMaxStartSilence(this.parameters.getMaxStartSilence().intValue());
        }
        if (this.parameters.getMaxEndSilence() != null) {
            this.recognizer.setMaxEndSilence(this.parameters.getMaxEndSilence().intValue());
        }
        if (this.parameters.getParams() != null) {
            this.recognizer.setParams(this.parameters.getParams());
        }
        this.recognizer.start();
        android.util.Log.d(TAG, "Recognizer with recorder started");
    }

    @Override // com.alibaba.idst.util.SpeechRecognizerCallback
    public void onRecognizedCompleted(java.lang.String str, int i) {
        this.recorder.stop();
        this.userCallback.onRecognizedCompleted(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechRecognizerCallback
    public void onRecognizedResultChanged(java.lang.String str, int i) {
        this.userCallback.onRecognizedResultChanged(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechRecognizerCallback
    public void onRecognizedStarted(java.lang.String str, int i) {
        this.userCallback.onRecognizedStarted(str, i);
    }

    @Override // com.alibaba.idst.util.SpeechRecognizerCallback
    public void onTaskFailed(java.lang.String str, int i) {
        this.recorder.stop();
        this.userCallback.onTaskFailed(str, i);
    }

    @Override // com.alibaba.idst.util.RecorderCallback
    public void onVoiceData(byte[] bArr, int i) {
        int iSendAudio = this.recognizer.sendAudio(bArr, i);
        if (iSendAudio >= 0) {
            this.userCallback.onVoiceData(bArr, i);
            return;
        }
        throw new java.lang.IllegalStateException("Send audio failed: " + iSendAudio);
    }

    @Override // com.alibaba.idst.util.RecorderCallback
    public void onVoiceVolume(int i) {
        this.userCallback.onVoiceVolume(i);
    }

    public void setAppkey(java.lang.String str) {
        this.parameters.setAppkey(str);
    }

    public void setMaxEndSilence(int i) {
        this.parameters.setMaxEndSilence(java.lang.Integer.valueOf(i));
    }

    public void setMaxStartSilence(int i) {
        this.parameters.setMaxStartSilence(java.lang.Integer.valueOf(i));
    }

    public void setParams(java.lang.String str) {
        this.parameters.setParams(str);
    }

    public void setToken(java.lang.String str) {
        this.parameters.setToken(str);
    }

    public void setUserCallback(com.alibaba.idst.util.SpeechRecognizerWithRecorderCallback speechRecognizerWithRecorderCallback) {
        this.userCallback = speechRecognizerWithRecorderCallback;
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
