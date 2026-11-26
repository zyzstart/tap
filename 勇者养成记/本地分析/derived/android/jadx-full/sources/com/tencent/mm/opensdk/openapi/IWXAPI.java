package com.tencent.mm.opensdk.openapi;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IWXAPI {
    void detach();

    int getWXAppSupportAPI();

    boolean handleIntent(android.content.Intent intent, com.tencent.mm.opensdk.openapi.IWXAPIEventHandler iWXAPIEventHandler);

    boolean isWXAppInstalled();

    boolean openWXApp();

    boolean registerApp(java.lang.String str);

    boolean registerApp(java.lang.String str, long j);

    boolean sendReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq);

    boolean sendResp(com.tencent.mm.opensdk.modelbase.BaseResp baseResp);

    void setLogImpl(com.tencent.mm.opensdk.utils.ILog iLog);

    void unregisterApp();
}
