package com.tencent.mm.opensdk.diffdev;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface OAuthListener {
    void onAuthFinish(com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode, java.lang.String str);

    void onAuthGotQrcode(java.lang.String str, byte[] bArr);

    void onQrcodeScanned();
}
