package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconView extends android.widget.LinearLayout implements com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface {
    private static final int MSG_ICON_CHANGE_ICON_WINDOW_HIDE = -1;
    private static final int MSG_ICON_CHANGE_ICON_WINDOW_SHADOW = 1;
    private static final java.lang.String TAG = "YSDK_ICON_VIEW";
    private static final long TIME_DELAY_HIDE_ICON = 300;
    private static final int TIME_DELAY_SHADOW_ICON = 0;
    private static final long TIME_ICON_MOVE = 800;
    private static final long TIME_SHOW_HIDE_ICON = 300;
    private static final java.lang.String UI_ID_ICON = "com_tencent_ysdk_icon_icon";
    private static final java.lang.String UI_ID_ICON_VIEW = "com_tencent_ysdk_icon_icon_layout";
    private static final java.lang.String UI_ID_RED_DOWN = "com_tencent_ysdk_icon_icon_redd";
    private static final java.lang.String UI_ID_RED_LEFT = "com_tencent_ysdk_icon_icon_redl";
    private static final java.lang.String UI_ID_RED_RIGHT = "com_tencent_ysdk_icon_icon_redr";
    private static final java.lang.String UI_ID_RED_UP = "com_tencent_ysdk_icon_icon_redu";
    private static final java.lang.String UI_LAYOUT_ICON_VIEW = "com_tencent_ysdk_icon_icon_view";
    private android.widget.ImageView mBallView;
    private int mEdge;

    @androidx.annotation.Nullable
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator mHideIconViewAnimator;
    private android.graphics.Bitmap mIconCache;
    private android.view.animation.Animation mIconMovingAnim;
    private android.view.View mLayout;
    private android.widget.ImageView mRedViewD;
    private android.widget.ImageView mRedViewL;
    private android.widget.ImageView mRedViewR;
    private android.widget.ImageView mRedViewU;
    private com.tencent.ysdk.shell.libware.thread.YSDKThreadManager mThreadManager;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy mTouchStrategy;
    private android.os.Handler mUiHandler;
    private int mViewHeight;
    private int mViewWidth;

    public IconView(android.content.Context context, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy iconViewTouchStrategy) {
        super(context);
        this.mEdge = 0;
        this.mUiHandler = new android.os.Handler(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0)) { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i = message.what;
                if (i != -1) {
                    if (i != 1) {
                        return;
                    }
                    com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.this.shadowIcon();
                } else {
                    java.lang.Object obj = message.obj;
                    if (obj instanceof com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface) {
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.this.hideIcon((com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface) obj);
                    }
                }
            }
        };
        this.mThreadManager = com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance();
        this.mTouchStrategy = iconViewTouchStrategy;
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_ICON_VIEW), this);
        this.mLayout = findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON_VIEW));
        this.mBallView = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ICON));
        this.mRedViewL = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_RED_LEFT));
        this.mRedViewR = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_RED_RIGHT));
        this.mRedViewU = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_RED_UP));
        this.mRedViewD = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_RED_DOWN));
        this.mViewWidth = this.mLayout.getLayoutParams().width;
        this.mViewHeight = this.mLayout.getLayoutParams().height;
        initIconMovingAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideIcon(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        this.mBallView.setAlpha(1.0f);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "hideIcon edge : " + this.mEdge);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator iHideIconViewAnimator = this.mHideIconViewAnimator;
        if (iHideIconViewAnimator != null) {
            iHideIconViewAnimator.startValueAnimatorByEdge(this.mEdge, iconViewInterface);
        }
    }

    private void initIconMovingAnim() {
        if (this.mIconMovingAnim == null) {
            this.mIconMovingAnim = new android.view.animation.RotateAnimation(359.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.mIconMovingAnim.setInterpolator(new android.view.animation.LinearInterpolator());
            this.mIconMovingAnim.setDuration(TIME_ICON_MOVE);
            this.mIconMovingAnim.setRepeatCount(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shadowIcon() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.mBallView.startAnimation(alphaAnimation);
    }

    private void updateIconOnUIThread() {
        try {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                this.mBallView.setImageBitmap(this.mIconCache);
            } else {
                this.mThreadManager.runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.this.mBallView.setImageBitmap(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView.this.mIconCache);
                    }
                });
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    private void updateRedPoint() {
        int i = this.mEdge;
        if (i == 2 || i == 3) {
            this.mRedViewR.setVisibility(4);
            this.mRedViewL.setVisibility(4);
            if (this.mEdge == 2) {
                this.mRedViewU.setVisibility(4);
                this.mRedViewD.setVisibility(0);
                return;
            } else {
                this.mRedViewD.setVisibility(4);
                this.mRedViewU.setVisibility(0);
                return;
            }
        }
        this.mRedViewU.setVisibility(4);
        if (this.mEdge == 0) {
            this.mRedViewL.setVisibility(4);
            this.mRedViewD.setVisibility(4);
            this.mRedViewR.setVisibility(0);
        } else {
            this.mRedViewR.setVisibility(4);
            this.mRedViewD.setVisibility(4);
            this.mRedViewL.setVisibility(0);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void clearIconLayoutAnimation() {
        if (this.mLayout.getAnimation() == null || !this.mLayout.getAnimation().hasStarted()) {
            return;
        }
        this.mLayout.clearAnimation();
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void clearViewAnimation() {
        this.mBallView.clearAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator iHideIconViewAnimator = this.mHideIconViewAnimator;
        if (iHideIconViewAnimator != null && iHideIconViewAnimator.isAnimatorRunning()) {
            return false;
        }
        if (this.mTouchStrategy != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearIconLayoutAnimation();
                    this.mBallView.startAnimation(this.mIconMovingAnim);
                    this.mUiHandler.removeMessages(1);
                    this.mUiHandler.removeMessages(-1);
                    this.mBallView.setAlpha(1.0f);
                    break;
                case 1:
                case 3:
                    clearViewAnimation();
                    startShadowIcon();
                    break;
            }
            this.mTouchStrategy.handleTouchEvent(this.mLayout, motionEvent);
        }
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getCurrentIconViewMode() {
        return 0;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getEdge() {
        return this.mEdge;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public android.view.View getIconBall() {
        return this.mBallView;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public android.view.View getIconView() {
        return this;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy getIconViewTouchStrategy() {
        return this.mTouchStrategy;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getLayoutViewHeight() {
        return this.mViewHeight;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public int getLayoutViewWidth() {
        return this.mViewWidth;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void onDestroy() {
        this.mUiHandler.removeMessages(1);
        this.mUiHandler.removeMessages(-1);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void setEdge(int i) {
        this.mEdge = i;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void setHideIconViewAnimator(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator iHideIconViewAnimator) {
        this.mHideIconViewAnimator = iHideIconViewAnimator;
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void startHideIcon(boolean z, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = -1;
        messageObtain.obj = iconViewInterface;
        if (z) {
            this.mUiHandler.sendMessageDelayed(messageObtain, 300L);
        } else {
            this.mUiHandler.sendMessage(messageObtain);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void startShadowIcon() {
        this.mUiHandler.sendEmptyMessageDelayed(1, 0L);
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void updateIconImage(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "Icon bitmap is Empty can`t update");
            return;
        }
        android.graphics.Bitmap bitmap2 = this.mIconCache;
        if (bitmap2 == null || bitmap2 != bitmap) {
            this.mIconCache = bitmap;
            updateIconOnUIThread();
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface
    public void updateViewContent(boolean z) {
        if (z) {
            updateRedPoint();
            return;
        }
        this.mRedViewR.setVisibility(4);
        this.mRedViewL.setVisibility(4);
        this.mRedViewU.setVisibility(4);
        this.mRedViewD.setVisibility(4);
    }
}
