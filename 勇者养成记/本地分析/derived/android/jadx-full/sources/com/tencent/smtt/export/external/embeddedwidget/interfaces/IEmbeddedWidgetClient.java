package com.tencent.smtt.export.external.embeddedwidget.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IEmbeddedWidgetClient {
    void onActive();

    void onDeactive();

    void onDestroy();

    void onRectChanged(android.graphics.Rect rect);

    void onRequestRedraw();

    void onSurfaceCreated(android.view.Surface surface);

    void onSurfaceDestroyed(android.view.Surface surface);

    boolean onTouchEvent(android.view.MotionEvent motionEvent);

    void onVisibilityChanged(boolean z);
}
