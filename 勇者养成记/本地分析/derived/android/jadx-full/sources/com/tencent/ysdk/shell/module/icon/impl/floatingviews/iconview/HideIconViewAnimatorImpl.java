package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HideIconViewAnimatorImpl implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator {
    private static final float ANIMATOR_FRACTION = 0.5f;
    private static final java.lang.String TAG = "HideIconViewAnimator";
    private static final long TIME_SHOW_HIDE_ICON = 300;
    private android.graphics.Point mBeforeLocation = new android.graphics.Point();
    private boolean mIsAnimatorRunning = false;
    private android.view.WindowManager.LayoutParams mLayoutParams;

    public HideIconViewAnimatorImpl(@androidx.annotation.NonNull android.view.WindowManager.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
    }

    private float getAnimatorVal(int i, int i2, int i3) {
        switch (i) {
            case 1:
                return i2 * 0.5f;
            case 2:
                return (-i3) * 0.5f;
            case 3:
                return i3 * 0.5f;
            default:
                return (-i2) * 0.5f;
        }
    }

    private android.view.WindowManager getWindowManager() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getWindowManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(int i, int i2, int i3, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, android.animation.ValueAnimator valueAnimator) {
        java.lang.Object animatedValue = valueAnimator.getAnimatedValue();
        if (!(animatedValue instanceof java.lang.Float)) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "animator update val error");
            return;
        }
        if (i3 == 0 || i3 == 1) {
            i = (int) (i + ((java.lang.Float) animatedValue).floatValue());
        } else if (i3 == 3 || i3 == 2) {
            i2 = (int) (i2 + ((java.lang.Float) animatedValue).floatValue());
        }
        android.view.WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.x = i;
        layoutParams.y = i2;
        getWindowManager().updateViewLayout(iconViewInterface.getIconView(), this.mLayoutParams);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator
    public void clearAnimator(android.view.View view) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "clearAnimator");
        try {
            if (this.mIsAnimatorRunning) {
                return;
            }
            this.mLayoutParams.x = this.mBeforeLocation.x;
            this.mLayoutParams.y = this.mBeforeLocation.y;
            getWindowManager().updateViewLayout(view, this.mLayoutParams);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator
    public boolean isAnimatorRunning() {
        return this.mIsAnimatorRunning;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator
    public void startValueAnimatorByEdge(final int i, final com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        if (this.mIsAnimatorRunning || iconViewInterface == null) {
            return;
        }
        this.mIsAnimatorRunning = true;
        float animatorVal = getAnimatorVal(i, iconViewInterface.getIconView().getMeasuredWidth(), iconViewInterface.getIconView().getMeasuredHeight());
        int i2 = (int) animatorVal;
        if (this.mLayoutParams.x == i2 || this.mLayoutParams.y == i2) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "don't need to move to edge");
            this.mIsAnimatorRunning = false;
            return;
        }
        final int i3 = this.mLayoutParams.x;
        final int i4 = this.mLayoutParams.y;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(animatorVal);
        this.mLayoutParams.flags = 552;
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                try {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.updateLocation(i3, i4, i, iconViewInterface, valueAnimator);
                } catch (java.lang.Exception e) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.TAG, e);
                }
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.mIsAnimatorRunning = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.mBeforeLocation.x = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.mLayoutParams.x;
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.mBeforeLocation.y = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl.this.mLayoutParams.y;
            }
        });
        valueAnimatorOfFloat.setDuration(TIME_SHOW_HIDE_ICON);
        valueAnimatorOfFloat.start();
    }
}
