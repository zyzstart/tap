package com.tencent.ysdk.shell.libware.device.notch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NotchInfo {
    private boolean mHasNotch;
    private android.graphics.Rect mRect = new android.graphics.Rect();

    public NotchInfo() {
    }

    public NotchInfo(android.graphics.Rect rect) {
        if (rect == null) {
            return;
        }
        this.mHasNotch = true;
        this.mRect.left = rect.left;
        this.mRect.top = rect.top;
        this.mRect.right = rect.right;
        this.mRect.bottom = rect.bottom;
    }

    public android.graphics.Rect getRect() {
        return this.mRect;
    }

    public boolean hasNotch() {
        return this.mHasNotch;
    }
}
