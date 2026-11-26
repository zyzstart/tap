package com.tencent.ysdk.shell.module.debug.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DebugIconView extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    private static final int DELTA_MOVEMENT = 60;
    private static final int MOVEMENT = 12;
    private static final java.lang.String UI_IMAGEVIEW_DEBUG_ICON_IMAGE = "com_tencent_ysdk_debug_icon_image";
    private static final java.lang.String UI_LAYOUT_DEBUG_ICON_VIEW = "com_tencent_ysdk_debug_icon_view";
    private static int sStatusBarHeight;
    private boolean mHasMoved;
    private android.view.animation.Animation mIconMovingAnim;
    private android.widget.ImageView mIconView;
    private android.view.WindowManager.LayoutParams mParams;
    private android.view.WindowManager mWindowManager;
    private float xDownInScreen;
    private float xInScreen;
    private float xInView;
    private float yDownInScreen;
    private float yInScreen;
    private float yInView;

    public DebugIconView(android.content.Context context) {
        super(context);
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_DEBUG_ICON_VIEW), this);
        this.mIconView = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_IMAGEVIEW_DEBUG_ICON_IMAGE));
        this.mParams = new android.view.WindowManager.LayoutParams(1000);
        android.view.WindowManager.LayoutParams layoutParams = this.mParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.gravity = 8388659;
        layoutParams.flags = 40;
        setOnClickListener(this);
        initIconMovingAnim();
    }

    private int getStatusBarHeight() {
        int identifier;
        if (sStatusBarHeight == 0 && (identifier = getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            sStatusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
        return sStatusBarHeight;
    }

    private void initIconMovingAnim() {
        if (this.mIconMovingAnim == null) {
            this.mIconMovingAnim = new android.view.animation.RotateAnimation(359.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.mIconMovingAnim.setInterpolator(new android.view.animation.LinearInterpolator());
            this.mIconMovingAnim.setDuration(800L);
            this.mIconMovingAnim.setRepeatCount(-1);
        }
    }

    private void moveToEdge() {
        android.view.WindowManager.LayoutParams layoutParams = this.mParams;
        layoutParams.x = 0;
        this.mWindowManager.updateViewLayout(this, layoutParams);
        setAlpha(1.0f);
    }

    private boolean needUpdateViewPosition() {
        return java.lang.Math.abs(this.xInScreen - this.xDownInScreen) > 12.0f || java.lang.Math.abs(this.yInScreen - this.yDownInScreen) > 12.0f;
    }

    private void updateViewPosition() {
        android.view.WindowManager.LayoutParams layoutParams = this.mParams;
        layoutParams.x = (int) (this.xInScreen - this.xInView);
        layoutParams.y = ((int) (this.yInScreen - this.yInView)) - 60;
        this.mWindowManager.updateViewLayout(this, layoutParams);
    }

    public void closeDebugIconView() {
        setVisibility(8);
        android.view.WindowManager windowManager = this.mWindowManager;
        if (windowManager != null) {
            windowManager.removeView(this);
        }
        this.mWindowManager = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().showDebugConfigView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        this.xInScreen = motionEvent.getRawX();
        this.yInScreen = motionEvent.getRawY() - getStatusBarHeight();
        switch (motionEvent.getAction()) {
            case 0:
                this.mIconView.startAnimation(this.mIconMovingAnim);
                this.xInView = motionEvent.getX();
                this.yInView = motionEvent.getY();
                this.xDownInScreen = motionEvent.getRawX();
                this.yDownInScreen = motionEvent.getRawY() - getStatusBarHeight();
                break;
            case 1:
                this.mIconView.clearAnimation();
                if (!this.mHasMoved) {
                    performClick();
                } else {
                    moveToEdge();
                    this.mHasMoved = false;
                }
                break;
            case 2:
                if (needUpdateViewPosition()) {
                    updateViewPosition();
                    this.mHasMoved = true;
                }
                break;
            default:
                this.mHasMoved = false;
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void showDebugIconView() {
        this.mWindowManager = com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().getWindowManager();
        if (getParent() == null) {
            this.mWindowManager.addView(this, this.mParams);
        } else {
            this.mWindowManager.updateViewLayout(this, this.mParams);
        }
    }
}
