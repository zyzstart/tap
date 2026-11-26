package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SpeechRecognizerCallback {
    void onChannelClosed(java.lang.String str, int i);

    void onRecognizedCompleted(java.lang.String str, int i);

    void onRecognizedResultChanged(java.lang.String str, int i);

    void onRecognizedStarted(java.lang.String str, int i);

    void onTaskFailed(java.lang.String str, int i);
}
