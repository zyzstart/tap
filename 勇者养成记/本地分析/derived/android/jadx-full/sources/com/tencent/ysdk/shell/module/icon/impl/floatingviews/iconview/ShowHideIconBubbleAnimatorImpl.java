package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShowHideIconBubbleAnimatorImpl implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator {
    private static final java.lang.String TAG = "ShowIconBubbleAnimatorImpl";
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback mCallback;
    private android.view.WindowManager.LayoutParams mLayoutParams;
    private android.graphics.Point mBeforeLocation = new android.graphics.Point();
    private boolean mIsAnimatorRunning = false;
    private int mBubbleMargin = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 7.0f);
    private int mBubbleHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 52.0f);
    private int mBubbleWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 139.0f);
    private int mBubbleBallSize = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 26.0f);
    private int mBubbleBallSourceSize = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 20.0f);
    private int mBubbleSourceSize = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 44.0f);

    public ShowHideIconBubbleAnimatorImpl(@androidx.annotation.NonNull android.view.WindowManager.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
    }

    private void correctLandscapeLocation(int i, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, android.graphics.Point point, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                if (iconViewInterface.getIconViewTouchStrategy() != null) {
                    iconViewInterface.getIconViewTouchStrategy().forceCorrectLocation(iconViewInterface.getIconView(), point);
                    if (point.x < 0) {
                        point.x = 0;
                    }
                    point.x += this.mBubbleMargin;
                    point.y = (int) (point.y + ((i3 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                    break;
                }
                break;
            case 1:
                point.x = (i4 - this.mBubbleMargin) - this.mBubbleWidth;
                point.y = (int) (point.y + ((i3 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                break;
            case 2:
                int i5 = point.x;
                int i6 = this.mBubbleWidth;
                int i7 = this.mBubbleMargin;
                if (i5 + i6 + i7 > i4) {
                    point.x = (i4 - i7) - i6;
                } else {
                    point.x = (int) (point.x + ((i2 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                }
                point.y = this.mBubbleMargin;
                break;
        }
    }

    private void correctPortraitLocation(int i, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, android.graphics.Point point, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                point.x = this.mBubbleMargin;
                point.y = (int) (point.y + ((i3 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                break;
            case 1:
                int i5 = point.x;
                int i6 = this.mBubbleWidth;
                int i7 = this.mBubbleMargin;
                if (i5 + i6 + i7 > i4) {
                    point.x = (i4 - i7) - i6;
                }
                point.y = (int) (point.y + ((i3 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                break;
            case 2:
                if (iconViewInterface.getIconViewTouchStrategy() != null) {
                    iconViewInterface.getIconViewTouchStrategy().forceCorrectLocation(iconViewInterface.getIconView(), point);
                    point.y += this.mBubbleMargin;
                    int i8 = point.x;
                    int i9 = this.mBubbleWidth;
                    int i10 = this.mBubbleMargin;
                    if (i8 + i9 + i10 <= i4) {
                        point.x = (int) (point.x + ((i2 / 2.0f) - (this.mBubbleHeight / 2.0f)));
                    } else {
                        point.x = (i4 - i10) - i9;
                    }
                    break;
                }
                break;
        }
    }

    private void correctSourceLocation(int i, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, android.graphics.Point point, int i2, int i3, int i4) {
        int orientation = com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(getCurrentActivity());
        if (orientation == 1) {
            correctPortraitLocation(i, iconViewInterface, point, i2, i3, i4);
        } else if (orientation == 2) {
            correctLandscapeLocation(i, iconViewInterface, point, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enlargeIconBallSize(android.view.View view, android.animation.ValueAnimator valueAnimator, int i, int i2, int i3, int i4) {
        float animatedFraction = (i3 - i) * valueAnimator.getAnimatedFraction();
        float animatedFraction2 = (i4 - i2) * valueAnimator.getAnimatedFraction();
        int i5 = (int) (animatedFraction + i);
        int i6 = (int) (animatedFraction2 + i2);
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i6;
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "width : " + layoutParams.width + " , height : " + layoutParams.height);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enlargeIconViewSize(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, android.animation.ValueAnimator valueAnimator, int i, int i2, int i3, int i4, android.view.WindowManager.LayoutParams layoutParams) {
        float animatedFraction = (i3 - i) * valueAnimator.getAnimatedFraction();
        float animatedFraction2 = (i4 - i2) * valueAnimator.getAnimatedFraction();
        layoutParams.width = (int) (animatedFraction + i);
        layoutParams.height = (int) (animatedFraction2 + i2);
    }

    private android.app.Activity getCurrentActivity() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity();
    }

    private android.animation.Animator getEmergeAnimator(final com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, final int i, final int i2, final int i3, final int i4, final int i5) {
        final android.graphics.Point point = new android.graphics.Point(i2, i3);
        correctSourceLocation(i, iconViewInterface, point, i4, i5, com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth(getCurrentActivity()));
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i4, this.mBubbleHeight);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl showHideIconBubbleAnimatorImpl = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this;
                showHideIconBubbleAnimatorImpl.enlargeIconViewSize(iconViewInterface, valueAnimator, i4, i5, showHideIconBubbleAnimatorImpl.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
                if (iconViewInterface.getIconBall().getParent() instanceof android.view.View) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.enlargeIconBallSize((android.view.View) iconViewInterface.getIconBall().getParent(), valueAnimator, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight);
                }
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.enlargeIconBallSize(iconViewInterface.getIconBall(), valueAnimator, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSize);
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.modifyLocation(valueAnimator, point.x, point.y, i, i2, i3, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.getWindowManager().updateViewLayout(iconViewInterface.getIconView(), com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                iconViewInterface.clearViewAnimation();
                iconViewInterface.clearIconLayoutAnimation();
            }
        });
        valueAnimatorOfFloat.setDuration(400L);
        return valueAnimatorOfFloat;
    }

    private android.animation.Animator getShrinkAnimator(final com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        final int i = this.mLayoutParams.x;
        final int i2 = this.mLayoutParams.y;
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(this.mBubbleHeight, iconViewInterface.getLayoutViewWidth());
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.enlargeIconBallSize(iconViewInterface.getIconBall(), valueAnimator, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleBallSourceSize);
                if (iconViewInterface.getIconBall().getParent() instanceof android.view.View) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.enlargeIconBallSize((android.view.View) iconViewInterface.getIconBall().getParent(), valueAnimator, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize);
                }
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl showHideIconBubbleAnimatorImpl = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this;
                showHideIconBubbleAnimatorImpl.enlargeIconViewSize(iconViewInterface, valueAnimator, showHideIconBubbleAnimatorImpl.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleSourceSize, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl showHideIconBubbleAnimatorImpl2 = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this;
                showHideIconBubbleAnimatorImpl2.rollbackLocation(valueAnimator, i, i2, showHideIconBubbleAnimatorImpl2.mLayoutParams);
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.getWindowManager().updateViewLayout(iconViewInterface.getIconView(), com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
            }
        });
        valueAnimatorOfInt.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams.width = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleWidth;
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams.height = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight;
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.getWindowManager().updateViewLayout(iconViewInterface.getIconView(), com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleStretchOrShrinkEnd();
                }
            }
        });
        valueAnimatorOfInt.setDuration(400L);
        return valueAnimatorOfInt;
    }

    private android.animation.ValueAnimator getStretchOrShrinkValueAnimator(final com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, int i, int i2, final boolean z) {
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                java.lang.Object animatedValue = valueAnimator.getAnimatedValue();
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleStretchingOrShrinking(((java.lang.Integer) animatedValue).intValue());
                }
            }
        });
        valueAnimatorOfInt.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleStretchOrShrinkStart();
                }
                if (z) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams.width = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleWidth;
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams.height = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBubbleHeight;
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.getWindowManager().updateViewLayout(iconViewInterface.getIconView(), com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mLayoutParams);
                }
            }
        });
        valueAnimatorOfInt.setDuration(500L);
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.WindowManager getWindowManager() {
        return getCurrentActivity().getWindowManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyLocation(android.animation.ValueAnimator valueAnimator, int i, int i2, int i3, int i4, int i5, android.view.WindowManager.LayoutParams layoutParams) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
                float animatedFraction = valueAnimator.getAnimatedFraction() * (i - i4);
                float animatedFraction2 = valueAnimator.getAnimatedFraction() * (i2 - i5);
                layoutParams.x = (int) (i4 + animatedFraction);
                layoutParams.y = (int) (i5 + animatedFraction2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rollbackLocation(android.animation.ValueAnimator valueAnimator, int i, int i2, android.view.WindowManager.LayoutParams layoutParams) {
        float animatedFraction = (this.mBeforeLocation.x - i) * valueAnimator.getAnimatedFraction();
        float animatedFraction2 = (this.mBeforeLocation.y - i2) * valueAnimator.getAnimatedFraction();
        layoutParams.x = (int) (i + animatedFraction);
        layoutParams.y = (int) (i2 + animatedFraction2);
    }

    private void startHideBubbleAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        android.animation.ValueAnimator stretchOrShrinkValueAnimator = getStretchOrShrinkValueAnimator(iconViewInterface, this.mBubbleWidth, this.mBubbleHeight, false);
        android.animation.Animator shrinkAnimator = getShrinkAnimator(iconViewInterface);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.setInterpolator(new android.view.animation.LinearInterpolator());
        animatorSet.playSequentially(stretchOrShrinkValueAnimator, shrinkAnimator);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mIsAnimatorRunning = false;
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleHideCompleted();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mIsAnimatorRunning = true;
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleStretchOrShrinkStart();
                }
            }
        });
        animatorSet.start();
    }

    private void startShowBubbleAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        int edge = iconViewInterface.getEdge();
        final int i = this.mLayoutParams.x;
        final int i2 = this.mLayoutParams.y;
        android.animation.Animator emergeAnimator = getEmergeAnimator(iconViewInterface, edge, i, i2, this.mLayoutParams.width, this.mLayoutParams.height);
        android.animation.ValueAnimator stretchOrShrinkValueAnimator = getStretchOrShrinkValueAnimator(iconViewInterface, this.mBubbleHeight, this.mBubbleWidth, true);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.setInterpolator(new android.view.animation.LinearInterpolator());
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mIsAnimatorRunning = false;
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleShowCompleted();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBeforeLocation.x = i;
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mBeforeLocation.y = i2;
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mIsAnimatorRunning = true;
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback != null) {
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl.this.mCallback.onBubbleShowStart();
                }
            }
        });
        animatorSet.playSequentially(emergeAnimator, stretchOrShrinkValueAnimator);
        animatorSet.start();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator
    public void clearAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        startHideBubbleAnimator(iconViewInterface);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator
    public boolean isAnimatorRunning() {
        return this.mIsAnimatorRunning;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator
    public void reset(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        android.view.ViewParent parent = iconViewInterface.getIconBall().getParent();
        if (parent instanceof android.view.ViewGroup) {
            android.view.ViewGroup.LayoutParams layoutParams = ((android.view.ViewGroup) parent).getLayoutParams();
            int i = this.mBubbleSourceSize;
            layoutParams.width = i;
            layoutParams.height = i;
        }
        android.view.ViewGroup.LayoutParams layoutParams2 = iconViewInterface.getIconBall().getLayoutParams();
        int i2 = this.mBubbleBallSourceSize;
        layoutParams2.width = i2;
        layoutParams2.height = i2;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator
    public void setOnShowHideBubbleCallback(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback onShowHideBubbleCallback) {
        this.mCallback = onShowHideBubbleCallback;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator
    public void showBubbleAndMsg(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface, java.lang.String str) {
        if (this.mIsAnimatorRunning || iconViewInterface == null || iconViewInterface.getIconView() == null || iconViewInterface.getIconView().getVisibility() != 0 || iconViewInterface.getIconView().getParent() == null) {
            return;
        }
        if (iconViewInterface instanceof com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) {
            ((com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) iconViewInterface).setIconViewMsg(str);
        }
        startShowBubbleAnimator(iconViewInterface);
    }
}
