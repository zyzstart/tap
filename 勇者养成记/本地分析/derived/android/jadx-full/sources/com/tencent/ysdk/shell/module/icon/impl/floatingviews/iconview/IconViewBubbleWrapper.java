package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconViewBubbleWrapper extends android.widget.FrameLayout implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback {
    private static final int HIDE_BUBBLE_TASK = 12288;
    private static final java.lang.String TAG = "IconViewBubbleWrapper";
    private android.graphics.Paint mBackgroundPaint;
    private android.graphics.RectF mBackgroundRectF;
    private int mBubbleBallPaddingPx;
    private int mBubbleSourceSize;
    private int mCurrentBubbleWidth;
    private int mCurrentMode;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface mIconView;
    private com.tencent.ysdk.module.msgbox.MsgItem mMsgItem;
    private android.graphics.Paint mRectPaint;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator mShowIconBubbleAnimator;
    private final android.widget.TextView mTvIconViewMsg;
    private android.os.Handler mUiHandler;

    public IconViewBubbleWrapper(android.content.Context context, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        super(context);
        this.mBackgroundRectF = new android.graphics.RectF();
        this.mCurrentMode = 0;
        this.mUiHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper.1
            @Override // android.os.Handler
            public void dispatchMessage(@androidx.annotation.NonNull android.os.Message message) {
                super.dispatchMessage(message);
                if (message.what != com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper.HIDE_BUBBLE_TASK) {
                    return;
                }
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper.this.hideBubble();
            }
        };
        setWillNotDraw(false);
        this.mIconView = iconViewInterface;
        addView(this.mIconView.getIconView());
        android.view.ViewGroup.LayoutParams layoutParams = this.mIconView.getIconView().getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mTvIconViewMsg = new android.widget.TextView(context);
        this.mTvIconViewMsg.setSingleLine();
        this.mTvIconViewMsg.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.mTvIconViewMsg.setTextColor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.ICON_VIEW_MSG_TEXT_COLOR);
        this.mTvIconViewMsg.setTextSize(14.0f);
        addView(this.mTvIconViewMsg);
        int iDip2px = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(context, 42.0f);
        int iDip2px2 = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(context, 15.0f);
        int iDip2px3 = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(context, 8.0f);
        this.mBubbleBallPaddingPx = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(context, 5.0f);
        this.mBubbleSourceSize = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 44.0f);
        android.view.ViewGroup.LayoutParams layoutParams2 = this.mTvIconViewMsg.getLayoutParams();
        if (layoutParams2 instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = iDip2px;
            marginLayoutParams.topMargin = iDip2px2;
            marginLayoutParams.rightMargin = iDip2px3;
        }
        this.mTvIconViewMsg.setLayoutParams(layoutParams2);
        this.mBackgroundPaint = new android.graphics.Paint();
        this.mRectPaint = new android.graphics.Paint();
        this.mRectPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mRectPaint.setColor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.BACKGROUND_RECT_COLOR);
        this.mBackgroundPaint.setColor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.BACKGROUND_COLOR);
        this.mRectPaint.setMaskFilter(new android.graphics.BlurMaskFilter(com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(context, 3.0f), android.graphics.BlurMaskFilter.Blur.SOLID));
        this.mRectPaint.setStrokeWidth(0.5f);
        this.mRectPaint.setColor(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.BACKGROUND_COLOR);
    }

    private void reportBubbleCloseEvent() {
        if (this.mMsgItem == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAppPkgName());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_BUBBLE_TYPE, java.lang.Integer.toString(this.mMsgItem.getMessageType()));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_BUBBLE_CLICK_FOR_HIDE, 0, "bubble show", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void clearIconLayoutAnimation() {
        this.mIconView.clearIconLayoutAnimation();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void clearViewAnimation() {
        this.mIconView.clearViewAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator iShowIconBubbleAnimator = this.mShowIconBubbleAnimator;
        if (iShowIconBubbleAnimator != null && iShowIconBubbleAnimator.isAnimatorRunning()) {
            return false;
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.mUiHandler.removeMessages(HIDE_BUBBLE_TASK);
        if (zDispatchTouchEvent) {
            if (this.mCurrentMode != 0 && motionEvent.getAction() == 1) {
                this.mShowIconBubbleAnimator.reset(this);
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            hideBubble();
            reportBubbleCloseEvent();
        }
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getCurrentIconViewMode() {
        return this.mCurrentMode;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getEdge() {
        return this.mIconView.getEdge();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public android.view.View getIconBall() {
        return this.mIconView.getIconBall();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public android.view.View getIconView() {
        return this;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy getIconViewTouchStrategy() {
        return this.mIconView.getIconViewTouchStrategy();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getLayoutViewHeight() {
        return this.mBubbleSourceSize;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getLayoutViewWidth() {
        return this.mBubbleSourceSize;
    }

    public void hideBubble() {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator iShowIconBubbleAnimator = this.mShowIconBubbleAnimator;
        if (iShowIconBubbleAnimator != null) {
            iShowIconBubbleAnimator.clearAnimator(this);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleHideCompleted() {
        this.mCurrentMode = 0;
        this.mTvIconViewMsg.setText("");
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleShowCompleted() {
        this.mCurrentMode = 1;
        if (this.mUiHandler.hasMessages(HIDE_BUBBLE_TASK)) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = this.mTvIconViewMsg.getLayoutParams();
        layoutParams.width = -2;
        this.mTvIconViewMsg.setLayoutParams(layoutParams);
        this.mUiHandler.sendEmptyMessageDelayed(HIDE_BUBBLE_TASK, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleShowStart() {
        this.mCurrentMode = 3;
        android.view.ViewGroup.LayoutParams layoutParams = this.mTvIconViewMsg.getLayoutParams();
        layoutParams.width = 0;
        this.mTvIconViewMsg.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleStretchOrShrinkEnd() {
        this.mCurrentMode = 3;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleStretchOrShrinkStart() {
        this.mCurrentMode = 2;
        android.view.ViewGroup.LayoutParams layoutParams = this.mTvIconViewMsg.getLayoutParams();
        layoutParams.width = 0;
        this.mTvIconViewMsg.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator.OnShowHideBubbleCallback
    public void onBubbleStretchingOrShrinking(int i) {
        this.mCurrentBubbleWidth = i;
        invalidate();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void onDestroy() {
        this.mIconView.onDestroy();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = getLayoutParams().height;
        if (this.mCurrentMode != 2) {
            i = getLayoutParams().width;
            this.mCurrentBubbleWidth = i;
        } else {
            i = this.mCurrentBubbleWidth;
        }
        android.graphics.RectF rectF = this.mBackgroundRectF;
        int i3 = this.mBubbleBallPaddingPx;
        rectF.left = i3;
        rectF.top = i3;
        rectF.right = i - i3;
        rectF.bottom = i2 - i3;
        float fCeil = (float) java.lang.Math.ceil(i2 / 2.0f);
        canvas.drawRoundRect(this.mBackgroundRectF, fCeil, fCeil, this.mBackgroundPaint);
        canvas.drawRoundRect(this.mBackgroundRectF, fCeil, fCeil, this.mRectPaint);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void setEdge(int i) {
        this.mIconView.setEdge(i);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void setHideIconViewAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator iHideIconViewAnimator) {
        this.mIconView.setHideIconViewAnimator(iHideIconViewAnimator);
    }

    public void setIconViewMsg(java.lang.String str) {
        this.mTvIconViewMsg.setText(str);
    }

    public void setShowIconBubbleAnimator(@androidx.annotation.NonNull com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator iShowIconBubbleAnimator) {
        this.mShowIconBubbleAnimator = iShowIconBubbleAnimator;
        this.mShowIconBubbleAnimator.setOnShowHideBubbleCallback(this);
    }

    public void showBubble(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.mMsgItem = msgItem;
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IShowIconBubbleAnimator iShowIconBubbleAnimator = this.mShowIconBubbleAnimator;
        if (iShowIconBubbleAnimator != null) {
            this.mCurrentMode = 1;
            iShowIconBubbleAnimator.showBubbleAndMsg(this, msgItem.getMsgAction().getText());
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void startHideIcon(boolean z, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        this.mIconView.startHideIcon(z, iconViewInterface);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void startShadowIcon() {
        this.mIconView.startShadowIcon();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void updateIconImage(android.graphics.Bitmap bitmap) {
        this.mIconView.updateIconImage(bitmap);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void updateViewContent(boolean z) {
        this.mIconView.updateViewContent(z);
    }
}
