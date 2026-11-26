package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class QuicException extends com.tencent.smtt.export.external.interfaces.NetworkException {
    protected QuicException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public abstract int getQuicDetailedErrorCode();
}
