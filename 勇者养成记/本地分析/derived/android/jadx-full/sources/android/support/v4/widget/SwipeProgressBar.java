package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final android.view.animation.Interpolator INTERPOLATOR = new android.support.v4.view.animation.FastOutSlowInInterpolator();
    private long mFinishTime;
    private android.view.View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;
    private final android.graphics.Paint mPaint = new android.graphics.Paint();
    private final android.graphics.RectF mClipRect = new android.graphics.RectF();
    private android.graphics.Rect mBounds = new android.graphics.Rect();
    private int mColor1 = COLOR1;
    private int mColor2 = Integer.MIN_VALUE;
    private int mColor3 = COLOR3;
    private int mColor4 = COLOR4;

    SwipeProgressBar(android.view.View view) {
        this.mParent = view;
    }

    private void drawCircle(android.graphics.Canvas canvas, float f, float f2, int i, float f3) {
        this.mPaint.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        float interpolation = INTERPOLATOR.getInterpolation(f3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, f, this.mPaint);
        canvas.restore();
    }

    private void drawTrigger(android.graphics.Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mColor1);
        float f = i;
        canvas.drawCircle(f, i2, this.mTriggerPercentage * f, this.mPaint);
    }

    void draw(android.graphics.Canvas canvas) {
        float f;
        int iWidth = this.mBounds.width();
        int iHeight = this.mBounds.height();
        int i = iWidth / 2;
        int i2 = iHeight / 2;
        int iSave = canvas.save();
        canvas.clipRect(this.mBounds);
        if (this.mRunning || this.mFinishTime > 0) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            long j = this.mStartTime;
            long j2 = (jCurrentAnimationTimeMillis - j) % com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY;
            long j3 = (jCurrentAnimationTimeMillis - j) / com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY;
            float f2 = j2 / 20.0f;
            boolean z = false;
            if (!this.mRunning) {
                long j4 = this.mFinishTime;
                if (jCurrentAnimationTimeMillis - j4 >= 1000) {
                    this.mFinishTime = 0L;
                    return;
                }
                float f3 = (((jCurrentAnimationTimeMillis - j4) % 1000) / 10.0f) / 100.0f;
                float f4 = i;
                float interpolation = INTERPOLATOR.getInterpolation(f3) * f4;
                this.mClipRect.set(f4 - interpolation, 0.0f, f4 + interpolation, iHeight);
                canvas.saveLayerAlpha(this.mClipRect, 0, 0);
                z = true;
            }
            if (j3 == 0) {
                canvas.drawColor(this.mColor1);
            } else if (f2 >= 0.0f && f2 < 25.0f) {
                canvas.drawColor(this.mColor4);
            } else if (f2 >= 25.0f && f2 < 50.0f) {
                canvas.drawColor(this.mColor1);
            } else if (f2 < 50.0f || f2 >= 75.0f) {
                canvas.drawColor(this.mColor3);
            } else {
                canvas.drawColor(this.mColor2);
            }
            if (f2 < 0.0f || f2 > 25.0f) {
                f = 0.0f;
            } else {
                drawCircle(canvas, i, i2, this.mColor1, ((f2 + 25.0f) * 2.0f) / 100.0f);
                f = 0.0f;
            }
            if (f2 >= f && f2 <= 50.0f) {
                drawCircle(canvas, i, i2, this.mColor2, (f2 * 2.0f) / 100.0f);
            }
            if (f2 >= 25.0f && f2 <= 75.0f) {
                drawCircle(canvas, i, i2, this.mColor3, ((f2 - 25.0f) * 2.0f) / 100.0f);
            }
            if (f2 >= 50.0f && f2 <= 100.0f) {
                drawCircle(canvas, i, i2, this.mColor4, ((f2 - 50.0f) * 2.0f) / 100.0f);
            }
            if (f2 >= 75.0f && f2 <= 100.0f) {
                drawCircle(canvas, i, i2, this.mColor1, ((f2 - 75.0f) * 2.0f) / 100.0f);
            }
            if (this.mTriggerPercentage > 0.0f && z) {
                canvas.restoreToCount(iSave);
                int iSave2 = canvas.save();
                canvas.clipRect(this.mBounds);
                drawTrigger(canvas, i, i2);
                iSave = iSave2;
            }
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
        } else {
            float f5 = this.mTriggerPercentage;
            if (f5 > 0.0f && f5 <= 1.0d) {
                drawTrigger(canvas, i, i2);
            }
        }
        canvas.restoreToCount(iSave);
    }

    boolean isRunning() {
        return this.mRunning || this.mFinishTime > 0;
    }

    void setBounds(int i, int i2, int i3, int i4) {
        android.graphics.Rect rect = this.mBounds;
        rect.left = i;
        rect.top = i2;
        rect.right = i3;
        rect.bottom = i4;
    }

    void setColorScheme(int i, int i2, int i3, int i4) {
        this.mColor1 = i;
        this.mColor2 = i2;
        this.mColor3 = i3;
        this.mColor4 = i4;
    }

    void setTriggerPercentage(float f) {
        this.mTriggerPercentage = f;
        this.mStartTime = 0L;
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    void start() {
        if (this.mRunning) {
            return;
        }
        this.mTriggerPercentage = 0.0f;
        this.mStartTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        this.mRunning = true;
        this.mParent.postInvalidate();
    }

    void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }
}
