package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SpeechSynthesizerCallback {
    void onBinaryReceived(byte[] bArr, int i);

    void onChannelClosed(java.lang.String str, int i);

    void onSynthesisCompleted(java.lang.String str, int i);

    void onSynthesisStarted(java.lang.String str, int i);

    void onTaskFailed(java.lang.String str, int i);
}
