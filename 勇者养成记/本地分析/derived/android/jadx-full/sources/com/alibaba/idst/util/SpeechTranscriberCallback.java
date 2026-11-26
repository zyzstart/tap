package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SpeechTranscriberCallback {
    void onChannelClosed(java.lang.String str, int i);

    void onSentenceBegin(java.lang.String str, int i);

    void onSentenceEnd(java.lang.String str, int i);

    void onTaskFailed(java.lang.String str, int i);

    void onTranscriptionCompleted(java.lang.String str, int i);

    void onTranscriptionResultChanged(java.lang.String str, int i);

    void onTranscriptionStarted(java.lang.String str, int i);
}
