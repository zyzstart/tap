package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconViewCommonTouchStrategy implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy {
    private static final int BASE_WHAT = 21;
    private static final int CLICK_CALLBACK = 21504;
    private static final long CLICK_TIME_OUT = android.view.ViewConfiguration.getTapTimeout();
    private static final int MIN_MOVE_DISTANCE = 12;
    private static final java.lang.String TAG = "IconViewCommonTouchStrategy";
    private static final int THROTTLE_CALLBACK = 43008;
    private static final long THROTTLE_TIME_OUT = 1000;
    private static boolean sIsAppNotchSupport;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback mCallback;
    private android.content.Context mContext;
    private boolean mIsClick;
    private boolean mIsClickConsumed;
    private boolean mIsThrottle;
    private float xDownInScreen;
    private float xInScreen;
    private float xInView;
    private float yDownInScreen;
    private float yInScreen;
    private float yInView;
    private java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor> mInterceptor = new java.util.ArrayList();
    private android.graphics.Point mLocation = new android.graphics.Point();
    private android.graphics.Rect mScreenRect = new android.graphics.Rect();
    private android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy.1
        @Override // android.os.Handler
        public void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy.CLICK_CALLBACK) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy.this.mIsClick = false;
            } else {
                if (i != com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy.THROTTLE_CALLBACK) {
                    return;
                }
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy.this.mIsThrottle = false;
            }
        }
    };

    public IconViewCommonTouchStrategy(android.content.Context context, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback iconViewTouchCallback) {
        this.mContext = context;
        this.mCallback = iconViewTouchCallback;
    }

    private void correctLocation(android.view.View view, android.graphics.Point point, boolean z) {
        if (!sIsAppNotchSupport) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "app not support notch");
            return;
        }
        for (com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor iconViewInterceptor : this.mInterceptor) {
            if (iconViewInterceptor.correctLocation(view, point, z)) {
                this.mScreenRect = iconViewInterceptor.getScreenRect();
                return;
            }
        }
    }

    private int getStatusBarHeight() {
        return com.tencent.ysdk.shell.libware.ui.ViewUtils.getStatusBarHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
    }

    private boolean handleActionClick(android.view.View view) {
        if (!this.mIsClick) {
            return false;
        }
        if (this.mIsClickConsumed) {
            return true;
        }
        this.mIsClickConsumed = true;
        this.mHandler.removeMessages(CLICK_CALLBACK);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback iconViewTouchCallback = this.mCallback;
        if (iconViewTouchCallback != null) {
            iconViewTouchCallback.onClick(view);
        }
        return true;
    }

    private void handleActionDown(android.view.MotionEvent motionEvent) {
        this.mIsClick = true;
        this.mIsClickConsumed = false;
        this.mIsThrottle = true;
        this.mHandler.sendEmptyMessageDelayed(CLICK_CALLBACK, CLICK_TIME_OUT);
        this.mHandler.sendEmptyMessageDelayed(THROTTLE_CALLBACK, THROTTLE_TIME_OUT);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback iconViewTouchCallback = this.mCallback;
        if (iconViewTouchCallback != null) {
            iconViewTouchCallback.onTouchDown();
        }
        this.xInView = motionEvent.getX();
        this.yInView = motionEvent.getY();
        this.xDownInScreen = motionEvent.getRawX();
        this.yDownInScreen = motionEvent.getRawY() - getStatusBarHeight();
    }

    private void handleActionMove(android.view.View view) {
        if (this.mIsClick) {
            this.mIsClick = false;
            this.mIsThrottle = false;
            this.mHandler.removeMessages(CLICK_CALLBACK);
            this.mHandler.removeMessages(THROTTLE_CALLBACK);
        }
        if (this.mCallback != null) {
            int i = (int) (this.xInScreen - this.xInView);
            int i2 = (int) (this.yInScreen - this.yInView);
            android.graphics.Point point = this.mLocation;
            point.x = i;
            point.y = i2;
            correctLocation(view, point);
            this.mCallback.onTouchMove(this.mLocation.x, this.mLocation.y);
        }
    }

    private void handleActionUp(android.view.View view) {
        int iJudgeEdge = judgeEdge();
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "edge : " + iJudgeEdge);
        if (this.mCallback != null) {
            android.graphics.Point point = this.mLocation;
            point.x = (int) this.xInScreen;
            point.y = (int) this.yInScreen;
            correctLocation(view, point);
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "x : " + this.mLocation.x + " , y : " + this.mLocation.y);
            this.mCallback.onTouchUp(this.mLocation.x, this.mLocation.y, iJudgeEdge);
        }
    }

    private int judgeEdge() {
        int screenWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(this.mContext);
        int screenHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenHeight(this.mContext);
        float f = this.xInScreen;
        float f2 = screenWidth;
        if (f - this.xInView > f2 / 2.0f) {
            float f3 = this.yInScreen;
            float f4 = screenHeight;
            if (f3 <= f4 - f3) {
                return f2 - f <= f3 ? 1 : 2;
            }
            return f2 - f <= f4 - f3 ? 1 : 3;
        }
        float f5 = this.yInScreen;
        float f6 = screenHeight;
        if (f5 <= f6 - f5) {
            return f <= f5 ? 0 : 2;
        }
        return f <= f6 - f5 ? 0 : 3;
    }

    private boolean needUpdateViewPosition() {
        return java.lang.Math.abs(this.xInScreen - this.xDownInScreen) > 12.0f || java.lang.Math.abs(this.yInScreen - this.yDownInScreen) > 12.0f;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public void addInterceptor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.IconViewInterceptor iconViewInterceptor) {
        this.mInterceptor.add(iconViewInterceptor);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public void correctLocation(android.view.View view, android.graphics.Point point) {
        correctLocation(view, point, false);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public void forceCorrectLocation(android.view.View view, android.graphics.Point point) {
        correctLocation(view, point, true);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public android.graphics.Rect getScreenRect() {
        return this.mScreenRect;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public void handleTouchEvent(android.view.View view, android.view.MotionEvent motionEvent) {
        this.xInScreen = motionEvent.getRawX();
        this.yInScreen = motionEvent.getRawY() - getStatusBarHeight();
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.mIsThrottle) {
                    handleActionDown(motionEvent);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "isThrottle");
                }
                break;
            case 1:
                if (!handleActionClick(view)) {
                    handleActionUp(view);
                    break;
                }
                break;
            case 2:
                if (needUpdateViewPosition()) {
                    handleActionMove(view);
                    break;
                }
                break;
            case 3:
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback iconViewTouchCallback = this.mCallback;
                if (iconViewTouchCallback != null) {
                    iconViewTouchCallback.onCancel();
                }
                break;
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy
    public void setAppNotchSupport(boolean z) {
        sIsAppNotchSupport = z;
    }
}
