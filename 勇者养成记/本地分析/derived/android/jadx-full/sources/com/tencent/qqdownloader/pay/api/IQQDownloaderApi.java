package com.tencent.qqdownloader.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IQQDownloaderApi {

    public interface AuthListener {
        void onAuthFailed(int i);

        void onAuthSuceed();
    }

    void auth(com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener);

    void handler(android.content.Intent intent);

    void setDebug(boolean z);
}
