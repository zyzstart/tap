package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface WebViewCallbackClient {
    void computeScroll(android.view.View view);

    boolean dispatchTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    void invalidate();

    boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    void onOverScrolled(int i, int i2, boolean z, boolean z2, android.view.View view);

    void onScrollChanged(int i, int i2, int i3, int i4, android.view.View view);

    boolean onTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, android.view.View view);
}
