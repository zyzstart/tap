package com.tencent.tauth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(java.lang.Object obj);

    void onError(com.tencent.tauth.UiError uiError);

    void onWarning(int i);
}
