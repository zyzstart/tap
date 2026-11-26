package com.tencent.ysdk.shell.module.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ShareInterface {
    void captureScreen();

    boolean checkWXCallBack(android.content.Intent intent);

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void regShareCallBack(com.tencent.ysdk.module.share.ShareCallBack shareCallBack);

    void setScreenCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer);

    void share(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareToBBS(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareToQQFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareToQZone(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareToWXFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareToWXTimeline(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void shareURLToQQFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void shareURLToQZone(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void shareURLToWXFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void shareURLToWXTimeline(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);
}
