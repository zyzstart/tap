package com.unisound.client;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SpeechUnderstanderListener {
    void onError(int i, java.lang.String str);

    void onEvent(int i, int i2);

    void onResult(int i, java.lang.String str);
}
