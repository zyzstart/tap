package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IShowIconBubbleAnimator {

    public interface OnShowHideBubbleCallback {
        void onBubbleHideCompleted();

        void onBubbleShowCompleted();

        void onBubbleShowStart();

        void onBubbleStretchOrShrinkEnd();

        void onBubbleStretchOrShrinkStart();

        void onBubbleStretchingOrShrinking(int i);
    }

    void clearAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface);

    boolean isAnimatorRunning();

    void reset(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface);

    void setOnShowHideBubbleCallback(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback onShowHideBubbleCallback);

    void showBubbleAndMsg(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, java.lang.String str);
}
