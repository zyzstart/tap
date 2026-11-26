package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YouMeAudioRecorder implements com.youme.voice.IAudioRecordListener {
    private static com.youme.voice.YouMeAudioRecorder s_instance;
    private com.youme.voice.IAudioRecordListener m_recordListener = null;
    private com.youme.voice.IAudioRecordListener m_recognizeListener = null;
    private com.youme.voice.AudioRecognizeType m_recognizeType = com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO;

    public static com.youme.voice.YouMeAudioRecorder Instance() {
        if (s_instance == null) {
            s_instance = new com.youme.voice.YouMeAudioRecorder();
        }
        return s_instance;
    }

    public com.youme.voice.AudioErrorCode CancleSpeech() {
        return com.youme.voice.AudioRecorder.Instance().CancelRecord();
    }

    public com.youme.voice.AudioDeviceStatus GetMicrophoneStatus() {
        return com.youme.voice.AudioRecorder.Instance().GetMicrophoneStatus();
    }

    public void Init(java.lang.String str) {
    }

    public boolean Init(android.content.Context context) {
        com.youme.voice.AudioRecorder.Instance().Init(context);
        com.youme.voice.AudioRecorder.Instance().SetRecordListener(this);
        return true;
    }

    @Override // com.youme.voice.IAudioRecordListener
    public byte[] OnRecordData(byte[] bArr, int i) {
        if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO == this.m_recognizeType) {
            com.youme.voice.IAudioRecordListener iAudioRecordListener = this.m_recordListener;
            if (iAudioRecordListener == null) {
                return null;
            }
            iAudioRecordListener.OnRecordData(bArr, i);
            return null;
        }
        com.youme.voice.IAudioRecordListener iAudioRecordListener2 = this.m_recognizeListener;
        if (iAudioRecordListener2 == null) {
            return null;
        }
        iAudioRecordListener2.OnRecordData(bArr, i);
        return null;
    }

    @Override // com.youme.voice.IAudioRecordListener
    public void OnRecordFinish(int i, java.lang.String str, long j, java.lang.String str2) {
        if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO == this.m_recognizeType) {
            com.youme.voice.IAudioRecordListener iAudioRecordListener = this.m_recordListener;
            if (iAudioRecordListener != null) {
                iAudioRecordListener.OnRecordFinish(i, str, j, str2);
                return;
            }
            return;
        }
        com.youme.voice.IAudioRecordListener iAudioRecordListener2 = this.m_recognizeListener;
        if (iAudioRecordListener2 != null) {
            iAudioRecordListener2.OnRecordFinish(i, str, j, str2);
        }
    }

    @Override // com.youme.voice.IAudioRecordListener
    public void OnRecordVolumeChange(int i, com.youme.voice.AudioRecognizeType audioRecognizeType) {
    }

    public void SetAudioRecordListener(com.youme.voice.IAudioRecordListener iAudioRecordListener) {
        this.m_recordListener = iAudioRecordListener;
    }

    public void SetAudioRecordParam(int i, int i2, int i3) {
        com.youme.voice.AudioRecorder.Instance().SetAudioRecordParam(i, i2, i3);
    }

    public void SetRecognizeListener(com.youme.voice.IAudioRecordListener iAudioRecordListener) {
        this.m_recognizeListener = iAudioRecordListener;
    }

    public void SetSpeechRecognizeParam(java.lang.String str, java.lang.String str2) {
    }

    public com.youme.voice.AudioErrorCode StartSpeech(java.lang.String str, long j, com.youme.voice.AudioRecognizeType audioRecognizeType) {
        this.m_recognizeType = audioRecognizeType;
        return com.youme.voice.AudioRecorder.Instance().StartRecord(j, str);
    }

    public com.youme.voice.AudioErrorCode StopSpeech() {
        return com.youme.voice.AudioRecorder.Instance().StopRecord();
    }

    public void UnInit() {
    }
}
