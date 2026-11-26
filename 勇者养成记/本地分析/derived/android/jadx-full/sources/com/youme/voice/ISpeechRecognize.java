package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ISpeechRecognize {

    public enum RecognizeLanguage {
        RECOGNIZELANG_MANDARIN(0),
        RECOGNIZELANG_YUEYU(1),
        RECOGNIZELANG_SICHUAN(2),
        RECOGNIZELANG_HENAN(3),
        RECOGNIZELANG_ENGLISH(4),
        RECOGNIZELANG_TRADITIONAL(5);

        private int value;

        RecognizeLanguage(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    com.youme.voice.AudioErrorCode CancleSpeech();

    boolean Init(android.content.Context context);

    void InitSpeechRecognizer(java.lang.String str, java.lang.String str2, com.youme.voice.AudioRecognizeType audioRecognizeType);

    void SetAudioRecordListener(com.youme.voice.IAudioRecordListener iAudioRecordListener);

    void SetAudioRecordParam(int i, int i2, int i3);

    void SetRecognizeLanguage(com.youme.voice.ISpeechRecognize.RecognizeLanguage recognizeLanguage);

    int StartSpeech(java.lang.String str, long j);

    com.youme.voice.AudioErrorCode StopSpeech();

    void UnInit();

    void UpdateToken(java.lang.String str);
}
