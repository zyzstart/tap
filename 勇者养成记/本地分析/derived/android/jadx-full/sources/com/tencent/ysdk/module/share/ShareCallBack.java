package com.tencent.ysdk.module.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ShareCallBack {
    void onCancel(com.tencent.ysdk.module.share.impl.ShareRet shareRet);

    void onError(com.tencent.ysdk.module.share.impl.ShareRet shareRet);

    void onSuccess(com.tencent.ysdk.module.share.impl.ShareRet shareRet);
}
