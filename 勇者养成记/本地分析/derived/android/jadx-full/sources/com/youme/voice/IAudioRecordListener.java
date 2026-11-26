package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAudioRecordListener {
    byte[] OnRecordData(byte[] bArr, int i);

    void OnRecordFinish(int i, java.lang.String str, long j, java.lang.String str2);

    void OnRecordVolumeChange(int i, com.youme.voice.AudioRecognizeType audioRecognizeType);
}
