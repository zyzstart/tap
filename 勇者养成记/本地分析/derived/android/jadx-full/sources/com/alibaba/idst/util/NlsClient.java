package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NlsClient {
    public static final java.lang.String NLS_GATEWAY = "wss://nls-gateway.cn-shanghai.aliyuncs.com:443/ws/v1";
    public static final int SAMPLE_RATE_16K = 16000;
    public static final int SAMPLE_RATE_8K = 8000;
    private long client;
    private com.alibaba.idst.util.SpeechRecognizerWithRecorder speechRecognizerWithRecorder;
    private com.alibaba.idst.util.SpeechTranscriberWithRecorder speechTranscriberWithRecorder;

    static {
        java.lang.System.loadLibrary("nlscppsdk");
    }

    public NlsClient() {
        this.client = 0L;
        this.client = initClient(true);
    }

    private native long buildRecognizerRequest(long j);

    private native long buildSynthesizerRequest(com.alibaba.idst.util.SpeechSynthesizerCallback speechSynthesizerCallback);

    private native long buildTranscriberRequest(long j);

    private native long createRecognizerCallback(com.alibaba.idst.util.SpeechRecognizerCallback speechRecognizerCallback);

    private native long createTranscriberCallback(com.alibaba.idst.util.SpeechTranscriberCallback speechTranscriberCallback);

    private native long initClient(boolean z);

    private native int logConfig(java.lang.String str);

    private native void releaseClient();

    public com.alibaba.idst.util.SpeechRecognizer createRecognizerRequest(com.alibaba.idst.util.SpeechRecognizerCallback speechRecognizerCallback) {
        long jCreateRecognizerCallback = createRecognizerCallback(speechRecognizerCallback);
        com.alibaba.idst.util.SpeechRecognizer speechRecognizer = new com.alibaba.idst.util.SpeechRecognizer(buildRecognizerRequest(jCreateRecognizerCallback), jCreateRecognizerCallback);
        speechRecognizer.setUrl(NLS_GATEWAY);
        speechRecognizer.setSampleRate(16000);
        speechRecognizer.setFormat("pcm");
        return speechRecognizer;
    }

    public com.alibaba.idst.util.SpeechRecognizerWithRecorder createRecognizerWithRecorder(com.alibaba.idst.util.SpeechRecognizerWithRecorderCallback speechRecognizerWithRecorderCallback) {
        if (this.speechRecognizerWithRecorder == null) {
            this.speechRecognizerWithRecorder = new com.alibaba.idst.util.SpeechRecognizerWithRecorder(this);
        }
        this.speechRecognizerWithRecorder.setUserCallback(speechRecognizerWithRecorderCallback);
        return this.speechRecognizerWithRecorder;
    }

    public com.alibaba.idst.util.SpeechSynthesizer createSynthesizerRequest(com.alibaba.idst.util.SpeechSynthesizerCallback speechSynthesizerCallback) {
        com.alibaba.idst.util.SpeechSynthesizer speechSynthesizer = new com.alibaba.idst.util.SpeechSynthesizer(buildSynthesizerRequest(speechSynthesizerCallback));
        speechSynthesizer.setUrl(NLS_GATEWAY);
        return speechSynthesizer;
    }

    public com.alibaba.idst.util.SpeechTranscriber createTranscriberRequest(com.alibaba.idst.util.SpeechTranscriberCallback speechTranscriberCallback) {
        long jCreateTranscriberCallback = createTranscriberCallback(speechTranscriberCallback);
        com.alibaba.idst.util.SpeechTranscriber speechTranscriber = new com.alibaba.idst.util.SpeechTranscriber(buildTranscriberRequest(jCreateTranscriberCallback), jCreateTranscriberCallback);
        speechTranscriber.setUrl(NLS_GATEWAY);
        speechTranscriber.setFormat("pcm");
        speechTranscriber.setSampleRate(16000);
        return speechTranscriber;
    }

    public com.alibaba.idst.util.SpeechTranscriberWithRecorder createTranscriberWithRecorder(com.alibaba.idst.util.SpeechTranscriberWithRecorderCallback speechTranscriberWithRecorderCallback) {
        if (this.speechTranscriberWithRecorder == null) {
            this.speechTranscriberWithRecorder = new com.alibaba.idst.util.SpeechTranscriberWithRecorder(this);
        }
        this.speechTranscriberWithRecorder.setUserCallback(speechTranscriberWithRecorderCallback);
        return this.speechTranscriberWithRecorder;
    }

    public void release() {
        this.speechTranscriberWithRecorder = null;
        this.speechTranscriberWithRecorder = null;
        releaseClient();
        this.client = 0L;
    }
}
