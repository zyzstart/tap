package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAudioPlayListener {
    void OnPlayData(byte[] bArr, int i);

    void OnPlayFinish(com.youme.voice.AudioErrorCode audioErrorCode, java.lang.String str);
}
