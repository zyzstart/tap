package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface HttpAuthHandler {
    void cancel();

    void proceed(java.lang.String str, java.lang.String str2);

    boolean useHttpAuthUsernamePassword();
}
