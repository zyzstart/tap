package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IHideIconViewAnimator {
    void clearAnimator(android.view.View view);

    boolean isAnimatorRunning();

    void startValueAnimatorByEdge(int i, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface);
}
