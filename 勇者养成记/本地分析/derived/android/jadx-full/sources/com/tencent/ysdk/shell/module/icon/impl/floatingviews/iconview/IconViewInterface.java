package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IconViewInterface {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface IconViewMode {
        public static final int BUBBLE_EMERGE_OR_SHRINK = 3;
        public static final int BUBBLE_MODE = 1;
        public static final int BUBBLE_STRETCHING_OR_SHRINKING = 2;
        public static final int NORMAL_MODE = 0;
    }

    void clearIconLayoutAnimation();

    void clearViewAnimation();

    int getCurrentIconViewMode();

    int getEdge();

    android.view.View getIconBall();

    android.view.View getIconView();

    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy getIconViewTouchStrategy();

    int getLayoutViewHeight();

    int getLayoutViewWidth();

    void onDestroy();

    void setEdge(int i);

    void setHideIconViewAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator iHideIconViewAnimator);

    void startHideIcon(boolean z, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface);

    void startShadowIcon();

    void updateIconImage(android.graphics.Bitmap bitmap);

    void updateViewContent(boolean z);
}
