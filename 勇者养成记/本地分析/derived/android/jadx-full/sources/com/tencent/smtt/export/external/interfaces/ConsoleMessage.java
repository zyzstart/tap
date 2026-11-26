package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ConsoleMessage {

    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    int lineNumber();

    java.lang.String message();

    com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel();

    java.lang.String sourceId();
}
