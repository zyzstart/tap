package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SslError {
    boolean addError(int i);

    android.net.http.SslCertificate getCertificate();

    int getPrimaryError();

    java.lang.String getUrl();

    boolean hasError(int i);
}
