package com.youme.speech;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UscSpeechRecognizer implements com.youme.voice.ISpeechRecognize {
    @Override // com.youme.voice.ISpeechRecognize
    public com.youme.voice.AudioErrorCode CancleSpeech() {
        return com.youme.voice.YouMeAudioRecorder.Instance().CancleSpeech();
    }

    @Override // com.youme.voice.ISpeechRecognize
    public boolean Init(android.content.Context context) {
        com.youme.voice.AudioRecorder.Instance().Init(context);
        return true;
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void InitSpeechRecognizer(java.lang.String str, java.lang.String str2, com.youme.voice.AudioRecognizeType audioRecognizeType) {
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void SetAudioRecordListener(com.youme.voice.IAudioRecordListener iAudioRecordListener) {
        com.youme.voice.YouMeAudioRecorder.Instance().SetAudioRecordListener(iAudioRecordListener);
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void SetAudioRecordParam(int i, int i2, int i3) {
        com.youme.voice.YouMeAudioRecorder.Instance().SetAudioRecordParam(i, i2, i3);
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void SetRecognizeLanguage(com.youme.voice.ISpeechRecognize.RecognizeLanguage recognizeLanguage) {
    }

    @Override // com.youme.voice.ISpeechRecognize
    public int StartSpeech(java.lang.String str, long j) {
        return com.youme.voice.YouMeAudioRecorder.Instance().StartSpeech(str, j, com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO).ordinal();
    }

    @Override // com.youme.voice.ISpeechRecognize
    public com.youme.voice.AudioErrorCode StopSpeech() {
        return com.youme.voice.YouMeAudioRecorder.Instance().StopSpeech();
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void UnInit() {
    }

    @Override // com.youme.voice.ISpeechRecognize
    public void UpdateToken(java.lang.String str) {
    }
}
