package com.unisound.client;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface FourMicAudioManagerListener {
    void onError(java.lang.String str);

    void onEvent(int i);

    void onRecordingData(byte[] bArr, int i);
}
