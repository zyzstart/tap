package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IconViewTouchStrategy {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface IconEdge {
        public static final int ICON_EDGE_DOWN = 3;
        public static final int ICON_EDGE_LEFT = 0;
        public static final int ICON_EDGE_RIGHT = 1;
        public static final int ICON_EDGE_UP = 2;
    }

    public interface IconViewTouchCallback {
        void onCancel();

        void onClick(android.view.View view);

        void onTouchDown();

        void onTouchMove(int i, int i2);

        void onTouchUp(int i, int i2, int i3);
    }

    void addInterceptor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor iconViewInterceptor);

    void correctLocation(android.view.View view, android.graphics.Point point);

    void forceCorrectLocation(android.view.View view, android.graphics.Point point);

    android.graphics.Rect getScreenRect();

    void handleTouchEvent(android.view.View view, android.view.MotionEvent motionEvent);

    void setAppNotchSupport(boolean z);
}
