package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ScreenCapture {
    private com.tencent.ysdk.module.share.impl.IScreenImageCapturer screenImageCapturer;

    public android.graphics.Bitmap captureScreen() {
        return this.screenImageCapturer.caputureImage();
    }

    public void setScreenImageCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer) {
        this.screenImageCapturer = iScreenImageCapturer;
    }
}
