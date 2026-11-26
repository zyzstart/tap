package com.unisound.client;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IAudioSource {
    void closeAudioIn();

    void closeAudioOut();

    int openAudioIn();

    int openAudioOut();

    int readData(byte[] bArr, int i);

    int writeData(byte[] bArr, int i);
}
